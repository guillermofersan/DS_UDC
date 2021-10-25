package e1;

public class Gamekeeper extends Staff{

    public Gamekeeper(String memberName, String memberSurname, int age, int horrocruxCount) {
        super(memberName, memberSurname, age, horrocruxCount);
        super.cat=Category.gamekeeper;
        baseSalary=170;
    }

    float getreward() {
        return 75*horcruxCount;
    }

    float getSalary() {
        return baseSalary+10;
    }

    String catString(){
        return "Gamekeeper";
    }
}
