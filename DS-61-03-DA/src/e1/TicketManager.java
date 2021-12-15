package e1;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketManager {

    private final List<Ticket> ticketList;


    public TicketManager(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }


    List<Ticket> search(Searchclause clause){
        if (clause==null) throw new IllegalArgumentException();
        List<Ticket> aux = clause.search(ticketList);
        Collections.sort(aux);
        return aux;
    }



    public static void main(String[] args) {
        /*

        Ticket t = new Ticket(new Origin("Madrid"),new Destination("coruña"), new Price(22.2), new TicketDate(LocalDate.of(2021,17,7)));
        Ticket t2 = new Ticket(new Origin("Huelva"),new Destination("Sevilla"), new Price(11.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t3 = new Ticket(new Origin("Madrid"),new Destination("Barcelona"), new Price(1.22), new TicketDate(LocalDate.of(2021,13,7)));
        Ticket t4 = new Ticket(new Origin("Sevilla"),new Destination("Barcelona"), new Price(1.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t5 = new Ticket(new Origin("Madrid"),new Destination("Francia"), new Price(0.), new TicketDate(LocalDate.of(2021,13,7)));


        List<Ticket> list= new ArrayList<>(Arrays.asList(t,t2,t3,t4,t5));

        TicketManager man = new TicketManager(list);

        Searchclause crit1 = new Origin("Madrid");
        Searchclause crit2 = new Destination("Barcelona");
        Searchclause crit3 = new TicketDate(LocalDate.of(2021,12,7));
        Searchclause crit4 = new Price(5.);
        Searchclause crit5 = new Price(1.);


        Searchclause clause1 = new ANDclause(crit1,crit2);
        Searchclause clause2 = new ANDclause(crit5,clause1); //empty
        Searchclause clause3 = new ORclause(new Origin("Huelva"), new Origin("Sevilla"));

        System.out.print("        Origin=madrid: " + man.search(crit1) +
                         "\nDestination=Barcelona: " + man.search(crit2) +
                         "\n       Date=7/12/2021: " + man.search(crit3)+
                         "\n             Price<=5: " + man.search(crit4) +
                         "\n\n og=madrid+dest=barc: " + man.search(clause1) +
                          "\n og=madrid+dest=barc: " + man.search(clause2) +
                         "\n\n huelva o sevilla: " + man.search(clause3)
        );



        System.out.print( + "\n");
        System.out.print( + "\n");

        System.out.print(man.searchByDest(new Destination("Barcelona")).toString() + "\n");

        System.out.print(man.searchByDate(new TicketDate(LocalDate.of(2021,12,7))).toString() + "\n");

        System.out.print(man.searchByPrice(new Price(5.)).toString() + "\n\n\n");

        System.out.print(man.search(man.searchByOrigin(new Origin("Madrid")),OR, man.searchByPrice(new Price(5.))).toString() + "\n");
        */

    }
}
