package e1;

import java.util.List;

public class and implements Operator{

    @Override
    public List<Ticket> operator(List<Ticket> l1, List<Ticket> l2) {
        l1.retainAll(l2);
        return l1;
    }
}
