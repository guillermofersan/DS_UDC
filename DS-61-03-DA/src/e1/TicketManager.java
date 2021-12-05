package e1;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TicketManager {

    private final List<Ticket> ticketList;


    public TicketManager(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    List<Ticket> searchByOrigin(Origin origin){

        List<Ticket> auxlist = new ArrayList<>();

        for (Ticket t : ticketList){
            if (t.getOrigin().equals(origin)){
                auxlist.add(t);
            }
        }

        return auxlist;
    }

    List<Ticket> searchByDest(Destination dest){

        List<Ticket> auxlist = new ArrayList<>();

        for (Ticket t : ticketList){
            if (t.getDestination().equals(dest)){
                auxlist.add(t);
            }
        }

        return auxlist;
    }

    List<Ticket> searchByPrice(Price price){

        List<Ticket> auxlist = new ArrayList<>();

        for (Ticket t : ticketList){
            if (t.getPrice().getPrice()<=price.getPrice()){
                auxlist.add(t);
            }
        }

        return auxlist;
    }

    List<Ticket> searchByDate(TicketDate date){

        List<Ticket> auxlist = new ArrayList<>();

        for (Ticket t : ticketList){
            if (t.getDate().equals(date)){
                auxlist.add(t);
            }
        }

        return auxlist;
    }

    List<Ticket> search(List<e1.Ticket> l1, Operator o, List<e1.Ticket> l2){

        return o.operator(l1, l2);

    }



    public static void main(String[] args) {

        Operator AND=new and();
        Operator OR=new or();

        Ticket t = new Ticket(new Origin("Madrid"),new Destination("coruña"), new Price(22.2), new TicketDate(LocalDate.of(2021,12,6)));
        Ticket t2 = new Ticket(new Origin("Huelva"),new Destination("Sevilla"), new Price(11.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t3 = new Ticket(new Origin("Madrid"),new Destination("Barcelona"), new Price(1.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t4 = new Ticket(new Origin("Sevilla"),new Destination("Barcelona"), new Price(1.22), new TicketDate(LocalDate.of(2021,12,7)));
        Ticket t5 = new Ticket(new Origin("Madrid"),new Destination("Francia"), new Price(0.), new TicketDate(LocalDate.of(2021,12,7)));


        List<Ticket> list= new ArrayList<>(Arrays.asList(t,t2,t3,t4,t5));

        TicketManager man = new TicketManager(list);

        System.out.print(man.searchByOrigin(new Origin("Madrid")).toString() + "\n");
        System.out.print(man.searchByOrigin(new Origin("Huelva")).toString() + "\n");
        System.out.print(man.searchByOrigin(new Origin("Sevilla")).toString() + "\n");

        System.out.print(man.searchByDest(new Destination("Barcelona")).toString() + "\n");

        System.out.print(man.searchByDate(new TicketDate(LocalDate.of(2021,12,7))).toString() + "\n");

        System.out.print(man.searchByPrice(new Price(5.)).toString() + "\n\n\n");

        System.out.print(man.search(man.searchByOrigin(new Origin("Madrid")),OR, man.searchByPrice(new Price(5.))).toString() + "\n");


    }
}
