package e4;

public class Calculator {

    float result;
    int op_count;
    String op_string="[STATE:";

    boolean error;





    public Calculator () {
        /*
         * Public constructor of the calculator .
         */
        result=0;
        op_count=0;
        error=false;

    }



    public void cleanOperations () {
        /*
         * Clean the internal state of the calculator
         */
        op_string = "[STATE:";
        result = 0;
        op_count = 0;
        error=false;


    }

    public void addOperation ( String operation , float ... values ) {

        /*
         * Add a new operation to the internal state of the calculator .
         * It is worth mentioning that the calculator behaves in an accumulative way ,
         * thus only first operation has two operands .
         * The rest of computations work with the accumulated value and only an extra
         * new operand . Second input value must be ignored if the operation does not
         * correspond to the first one.
         *
         * @param operation operation to add , as string , "+" , " -" , "*" , "/".
         * @param values Operands of the new operation ( one or two operands ).
         * Uses the varargs feature .
         * https :// docs . oracle . com / javase /8/ docs / technotes / guides / language / varargs . html
         * @throws IllegalArgumentException If the operation does not exist .
         */

        float op1, op2;
        if(op_count==0){
            op1=values[0];
            op2=values[1];

            op_string+="["+operation+"]"+ op1 + "_" + op2;
        }
        else{
            op1=result;
            op2=values[0];
            op_string+="["+operation+"]"+op2;

        }


        switch(operation){
            case "+":
                result=op1+op2;
                break;

            case "-":
                result=op1-op2;
                break;

            case "*":
                result=op1*op2;
                break;

            case "/":
                if (op2==0) error=true;
                else result=op1/op2;
                break;

            default:
                op_string = "[STATE:";
                op_count = 0;
                error=false;
                result=0;
                throw new IllegalArgumentException();
        }

        op_count++;

        /*  3+1 = 4 ;  4+2 = 6; 6/2 = 3  */
        /*  (((3+1)+2)/2)  */
    }

    public float executeOperations () {

        /*
         * Execute the set of operations of the internal state of the calculator .
         * Once execution is finished , internal state ( operands and operations )
         * is restored ( EVEN if exception occurs ).
         * This calculator works with " Batches " of operations .
         * @return result of the execution
         * @throws ArithmeticException If the operation returns an invalid value
         * ( division by zero )
         */
        float final_result=result;




        op_string = "[STATE:";
        op_count = 0;

        result=0;

        if (error){
            error=false;
            throw new ArithmeticException();
        }
        error=false;


        return final_result;

    }

    @Override
    public String toString () {
        /*
         * Current internal state of calculator is printed
         * FORMAT :
         * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
         * EXAMPLES : JUnit tests
         * @return String of the internal state of the calculator
         */


        return op_string+"]";
    }
}