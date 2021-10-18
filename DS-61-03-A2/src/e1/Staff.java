package e1;

public class Staff extends Members{

    enum staffType{Teacher, Gamekeeper, Caretaker}

    staffType type;

    public Staff(String memberName, staffType type) {
        super(memberName);
        this.type = type;
    }
}
