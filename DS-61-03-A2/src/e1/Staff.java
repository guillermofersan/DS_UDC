package e1;

import java.lang.reflect.Member;

abstract public class Staff extends Members{

    int baseSalary;

    public Staff(String memberName, String memberSurname, int age, int horrocruxCount) {
        super(memberName, memberSurname, age, horrocruxCount);
    }

    abstract int getSalary();

    String printSalary(){
        return memberName + " " + memberSurname
                + " ( " +  catString() + " ): "
                + getSalary() + " galleons";
    }

}
