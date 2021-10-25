package e1;

public class Caretaker extends Staff{

    public Caretaker(String memberName, String memberSurname, int age, int horrocruxCount) {
        super(memberName, memberSurname, age, horrocruxCount);
        super.cat=Category.caretaker;
        baseSalary=150;
    }

    float getreward(){
        return 65*horcruxCount;
    }

    float getSalary() {
        return baseSalary+10;
    }

    String catString(){
        return "Caretaker";
    }
}