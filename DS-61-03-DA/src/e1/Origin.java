package e1;

import java.util.Objects;

final public class Origin {
    final private String origin;

    public Origin(String origin) {
        if (origin==null) throw new IllegalArgumentException();
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Origin)) return false;
        Origin origin1 = (Origin) o;
        return origin.equals(origin1.getOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin);
    }
}
