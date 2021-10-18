package e1;

public class Residents extends Members{

    enum ResidentHouse {Griffindor, Hufflepuff, Ravenclaw, Slytherin}

    ResidentHouse resHouse;

    public Residents(String memberName, ResidentHouse house) {
        super(memberName);
        resHouse=house;

    }
}
