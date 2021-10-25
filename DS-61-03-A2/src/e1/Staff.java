package e1;

import java.lang.reflect.Member;

abstract public class Staff extends Members{

    float baseSalary;

    public Staff(String memberName, String memberSurname, int age, int horrocruxCount) {
        super(memberName, memberSurname, age, horrocruxCount);
    }

    abstract float getSalary();

    String printSalary(){

        return memberName + " " + memberSurname
                + " ( " +  catString() + " ): "
                + getSalary() + " galleons";
    }

}
