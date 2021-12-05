package e1;

final public class Price {
    final private Double price;

    public Price(Double price) {
        if (price<0) throw new IllegalArgumentException();
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

}
