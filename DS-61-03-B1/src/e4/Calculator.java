package e4;

import java.util.ArrayList;

import static e4.Calculator.operations.*;

public class Calculator {

    int op_count;
    ArrayList<operations> opList;
    float[] operators;

    public void clearState(){
        opList.clear();
        op_count=0;
    }

    public enum operations {
        SUM,
        SUB,
        DIV,
        MUL;

        public float SolveOP(float op1, float op2){

            float result = switch (this) {
                case SUM -> op1 + op2;
                case SUB -> op1 - op2;
                case DIV ->op1 / op2;
                case MUL -> op1 * op2;
            };

            return result;
        }
    }


    public Calculator() {
        /*
         * Public constructor of the calculator .
         */

    }

    public void cleanOperations() {

        /*
         * Clean the internal state of the calculator
         */
        op_count = 0;
        opList.clear();
    }

    public void addOperation(String operation, float... values) {
        /*
          Add a new operation to the internal state of the calculator .
          It is worth mentioning that the calculator behaves in an accumulative way ,
          thus only first operation has two operands .
          The rest of computations work with the accumulated value and only an extra
          new operand . Second input value must be ignored if the operation does not
          correspond to the first one.
          @param operation operation to add , as string , "+" , " -" , "*" , "/".
         * @param values Operands of the new operation ( one or two operands ).
         * Uses the varargs feature .
         * https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
         * @throws IllegalArgumentException If the operation does not exist .
         */

        float op1, op2;
        if (op_count == 0) {
            op1 = values[0];
            op2 = values[1];

        } else {
            op2 = values[0];
        }

        switch (operation) {
            case "+":
                opList.add(SUM);
                break;

            case "-":
                opList.add(SUB);
                break;

            case "*":
                opList.add(MUL);
                break;

            case "/":
                opList.add(DIV);
                break;

            default:
                throw new IllegalArgumentException();
        }

        op_count++;

    }

    public float executeOperations() {

        /*
         * Execute the set of operations of the internal state of the calculator .
         * Once execution is finished , internal state ( operands and operations )
         * is restored ( EVEN if exception occurs ).
         * This calculator works with " Batches " of operations .
         * @return result of the execution
         * @throws ArithmeticException If the operation returns an invalid value
         * ( division by zero )
         */
        float result = 0;



        for (int i=0;i<=op_count-1;i++){
            if (op_count==0 && !opList.isEmpty()){
                result=opList.get(0).SolveOP(operators[0],operators[1]);
            } else{
                result=opList.get(i).SolveOP(result,operators[i+1]);
            }

        }

        op_count = 0;

        return result;
    }

    @Override
    public String toString() {
        /*
         * Current internal state of calculator is printed
         * FORMAT :
         * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
         * EXAMPLES : JUnit tests
         * @return String of the internal state of the calculator
         */

        return "";
    }
}