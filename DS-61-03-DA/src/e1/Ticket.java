package e1;

import java.util.Date;

public class Ticket {

    private final String origin, destination;
    private final Float price;
    private final Date date;

    public Ticket(String origin, String destination, Float price, Date date) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Float getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}
