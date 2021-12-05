package e1;

import java.time.LocalDate;
import java.util.Objects;

final public class TicketDate {
    final private LocalDate date;

    public TicketDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketDate)) return false;
        TicketDate that = (TicketDate) o;
        return date.equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
