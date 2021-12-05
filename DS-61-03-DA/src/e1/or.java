package e1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class or implements Operator{

    @Override
    public List<Ticket> operator(List<Ticket> l1, List<Ticket> l2) {
        Set<Ticket> aux = new HashSet<>(l1);
        aux.addAll(l2);
        return new ArrayList<>(aux);
    }
}
