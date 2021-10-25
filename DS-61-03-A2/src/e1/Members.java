package e1;

enum Category{ghost,student,gamekeeper,caretaker,teacher}

abstract public class Members {

    String memberName;
    String memberSurname;
    int age;
    int horcruxCount;
    Category cat;

    public Members(String memberName, String memberSurname, int age, int horrocruxCount) {
        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.age = age;
        this.horcruxCount = horrocruxCount;
    }

    abstract float getreward();

    abstract String catString();

    String printRewards(){

        return memberName + " " + memberSurname
                + " ( " +  catString() + " ): "
                + getreward() + " galleons";
    }

}
