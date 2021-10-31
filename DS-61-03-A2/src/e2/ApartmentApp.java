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

    public void sortList(){ //by actual criteria
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

    public int len(){
        return adList.size();
    }

    public Advertisement getAd(int i){
        if (i >= adList.size())
            throw new IllegalArgumentException();
        return adList.get(i);
    }

    /*
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        for (Advertisement a : adList) {

            s.append("Advertisement ").append(a.getRefNum()).append("\n").append(a).append("\n");
        }

        return s.toString();
    }

     */

}
