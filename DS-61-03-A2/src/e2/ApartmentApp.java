package e2;

import java.util.ArrayList;
import java.util.Collections;

public class ApartmentApp {

    ArrayList<Advertisement> adList;

    enum criteria{basePrice, totalPrice, size, beds}

    criteria crit;

    public ApartmentApp() {
        adList = new ArrayList<>();
        crit=null;
    }

    void insertApartment(String location, float basePrice, float size, int beds, int parkingSpots, float... parkingPrices) {

        adList.add(new Advertisement(adList.size() + 1, location, basePrice, size, beds, parkingSpots, parkingPrices));

    }

    public void changeOrderingCriteria(criteria crit) {
        this.crit = crit;
    }

    public void orderList(){ //by actual criteria
        if (crit==null)
            Collections.sort(adList);
        else{
            switch (crit){
                case basePrice -> adList.sort(new OrderBasePrice());
                case totalPrice -> adList.sort(new OrderTotalPrice());
                case size -> adList.sort(new OrderSize());
                case beds -> adList.sort(new OrderBeds());

            }
        }

    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (Advertisement a : adList) {

            s.append("Advertisement ").append(a.getRefNum()).append("\n").append(a).append("\n\n");
        }

        return s.toString();
    }


    public static void main(String[] args) {
        ApartmentApp app;

        app = new ApartmentApp();
        app.insertApartment("Calle Rosalia de castro 2",100,100,3,1,4);
        app.insertApartment("Calle Rosalia de castro 3",200,99,101,2,5,7);
        app.insertApartment("Calle Rosalia de castro 4",5,99,1,5,1,7,100,5,3);
        app.insertApartment("Calle Rosalia de castro 4",5,99,1,5,7,1,5,3,100);


        System.out.println("Natural order \n----------------------\n" + app);

        app.changeOrderingCriteria(criteria.basePrice);
        app.orderList();
        System.out.println("base price order \n----------------------\n" + app);

        app.changeOrderingCriteria(criteria.totalPrice);
        app.orderList();
        System.out.println("total price order \n----------------------\n" + app);

        app.changeOrderingCriteria(criteria.size);
        app.orderList();
        System.out.println("size order \n----------------------\n" + app);

        app.changeOrderingCriteria(criteria.beds);
        app.orderList();
        System.out.println("beds order \n----------------------\n" + app);

        app.changeOrderingCriteria(null);
        app.orderList();
        System.out.println("natural order \n----------------------\n" + app);



    }

}
