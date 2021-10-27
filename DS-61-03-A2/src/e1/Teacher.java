package e1;

public class Teacher extends Staff{

    enum subjects{History, Transfiguration, Defence, Herbology, Potions};

    subjects subj;

    public Teacher(String memberName, String memberSurname, int age, int horrocruxCount, subjects subj) {
        super(memberName, memberSurname, age, horrocruxCount);
        this.subj = subj;

        baseSalary  = switch (subj){
            case History -> 200;
            case Herbology -> 250;
            case Potions -> 350;
            case Transfiguration -> 400;
            case Defence -> 500;
        };
    }

    float getreward(){

        float reward=50*horcruxCount;

        if (subj==subjects.Defence) reward*=0.75;

        return reward;
    }

    int getSalary(){
        return baseSalary;
    }

    String catString(){
        return "Teacher of " + subj;
    }

}
