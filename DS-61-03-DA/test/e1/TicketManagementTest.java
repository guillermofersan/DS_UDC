package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagementTest {

    private TicketManager manager;
    Operator AND, OR;


    @BeforeEach
    void setUp() {


        Ticket t = new Ticket(new Origin("Madrid"),new Destination("Coruña"), new Price(22.2), new TicketDate(LocalDate.of(2021,12,6)));
        Ticket t2 = new Ticket(new Origin("Huelva"),new Destination("Sevilla"), new Price(11.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t3 = new Ticket(new Origin("Madrid"),new Destination("Barcelona"), new Price(1.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t4 = new Ticket(new Origin("Sevilla"),new Destination("Barcelona"), new Price(1.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t5 = new Ticket(new Origin("Madrid"),new Destination("Francia"), new Price(0.), new TicketDate(LocalDate.of(2021,12,7)));

        List<Ticket> list= new ArrayList<>(Arrays.asList(t,t2,t3,t4,t5));
        manager = new TicketManager(list);
    }


}
