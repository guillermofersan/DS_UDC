package e1;

public class Teachers extends Staff{

    enum subjects{History, Transfiguration, Defence, Herbology, Potions};

    subjects subj;

    public Teachers(String memberName, staffType type, subjects subj) {
        super(memberName, type);
        this.subj = subj;
    }
}
