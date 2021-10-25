package e1;

public class Residents extends Members{

    enum ResidentHouse {Griffindor, Hufflepuff, Ravenclaw, Slytherin}


    ResidentHouse resHouse;


    public Residents(String memberName, String memberSurname, int age, int horrocruxCount, ResidentHouse resHouse, Category cat) {
        super(memberName, memberSurname, age, horrocruxCount);
        this.resHouse = resHouse;

        super.cat=cat;
    }

    float getreward() {
        float total = switch (cat) {
            case student -> 90 * horcruxCount;
            case ghost -> 80 * horcruxCount;
            default -> 0;
        };
        if (resHouse==ResidentHouse.Slytherin) total*=2;

        return total;
    }
    String catString(){
        return cat + " of " + resHouse;
    }

}
