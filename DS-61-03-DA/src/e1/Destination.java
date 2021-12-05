package e1;

import java.util.Objects;

final public class Destination {
    final private String destination;

    public Destination(String destination) {
        if (destination==null) throw new IllegalArgumentException();
        this.destination = destination;
    }

    public String getdestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination d2 = (Destination) o;
        return destination.equals(d2.getdestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }
}
