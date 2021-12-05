package e1;

import java.util.Date;

final public class Ticket {

    final private Origin origin;
    final private Destination destination;
    final private Price price;
    final private TicketDate date;

    public Ticket(Origin origin, Destination destination, Price price, TicketDate date) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.date = date;
    }

    public Origin getOrigin() {
        return origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public Price getPrice() {
        return price;
    }

    public TicketDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "origin=" + origin.getOrigin() +
                ", destination=" + destination.getdestination() +
                ", price=" + price.getPrice() +
                ", date=" + date.getDate() +
                '}';
    }
}
