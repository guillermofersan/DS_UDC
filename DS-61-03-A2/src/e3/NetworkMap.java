package e3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NetworkMap implements NetworkManager{

    HashMap<String, List<TopicOfInterest>> usersMap;

    public NetworkMap() {


        usersMap = new HashMap<>();

    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {

        usersMap.put(user,topicsOfInterest);

    }

    @Override
    public void removeUser(String user) {

        if (!usersMap.containsKey(user)) throw new IllegalArgumentException();

        usersMap.remove(user);



    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {

        List<TopicOfInterest> topList = usersMap.get(user);
        topList.add(topicOfInterest);

        usersMap.replace(user,topList);

    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {

        List<TopicOfInterest> topList = usersMap.get(user);

        if (!topList.remove(topicOfInterest))
            throw new IllegalArgumentException();

        usersMap.replace(user,topList);

    }

    @Override
    public List<String> getUsers() {

        return usersMap.keySet().stream().toList();
    }

    @Override
    public List<TopicOfInterest> getInterests() {

        List<TopicOfInterest> aux, allTopics;
        allTopics = new ArrayList<>();

        Iterator<String> it = usersMap.keySet().iterator();

        while(it.hasNext()){
            String key = it.next();

            aux=usersMap.get(key);

            for (TopicOfInterest topic : aux){
                if (!allTopics.contains(topic)){
                    allTopics.add(topic);
                }
            }
        }



        return allTopics;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {

        List<TopicOfInterest> topList;

        if ((topList=usersMap.get(user))==null) throw new IllegalArgumentException();

        return topList;
    }


    @Override
    public String toString() {

        StringBuilder total= new StringBuilder();
        List<TopicOfInterest> aux;

        Iterator<String> it = usersMap.keySet().iterator();

        total.append("USERNAME: INTERESTS\n---------------------\n");

        while(it.hasNext()){
            String key = it.next();
            total.append(key).append(": ");

            aux=usersMap.get(key);

            for (int i=0; i<aux.size();++i){
                total.append(aux.get(i));
                if (i!=(aux.size()-1))
                    total.append(", ");
            }

            if (it.hasNext())
                total.append("\n");



        }

        return total.toString();

    }

}

