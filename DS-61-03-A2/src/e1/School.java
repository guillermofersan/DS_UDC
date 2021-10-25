package e1;


import java.lang.reflect.Member;
import java.util.ArrayList;

public class School {

    ArrayList<Members> membersList;

    public School() {
        membersList= new ArrayList<>();
    }

    void addmember(Members member){

        membersList.add(member);

    }

    String printRewards(){

        return "";

    }

    String printSalaries(){

        return "";
    }

}
