package e1;

public class Resident extends Members{

    enum ResidentHouse {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}

    enum Category {Student, Ghost}


    ResidentHouse resHouse;
    Category cat;

    public Resident(String memberName, String memberSurname, int age, int horrocruxCount, ResidentHouse resHouse, Category cat) {
        super(memberName, memberSurname, age, horrocruxCount);
        this.resHouse = resHouse;
        this.cat=cat;

    }

    float getreward() {
        float total = switch (cat) {
            case Student -> 90 * horcruxCount;
            case Ghost -> 80 * horcruxCount;
            //default -> 0;
        };
        if (resHouse==ResidentHouse.Slytherin) total*=2;

        return total;
    }
    String catString(){
        return cat + " of " + resHouse;
    }

}
