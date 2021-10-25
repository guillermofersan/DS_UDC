package e1;

public class Teachers extends Members{

    enum subjects{History, Transfiguration, Defence, Herbology, Potions};

    subjects subj;

    public Teachers(String memberName, String memberSurname, int age, int horrocruxCount, subjects subj) {
        super(memberName, memberSurname, age, horrocruxCount);
        super.cat=Category.teacher;
        this.subj = subj;
    }

    float getreward(){
        return 50*horcruxCount;
    }

    float getsalary(){

        float total= switch (subj){
            case History -> 200;
            case Herbology -> 250;
            case Potions -> 350;
            case Transfiguration -> 400;
            case Defence -> 500;
        };
        return total;
    }

    String catString(){
        return "Teacher of " + subj;
    }

}
