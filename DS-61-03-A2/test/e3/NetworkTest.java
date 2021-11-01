package e3;

import e2.ApartmentApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NetworkTest {

    private Network networkT,networkM;

    @BeforeEach
    void setUp() {
        networkT = new Network(new NetworkTables());
        networkM = new Network(new NetworkMap());

        networkM.addUser("Juan","Football","Wrestling");
        networkM.addUser("Maria","Manga","Anime","League of Legends","WoW","CSgo");
        networkM.addUser("Carlos","Anime","Shopping","Movies");
        networkM.addUser("Enrique","Basketball","League of Legends");
        networkM.addUser("Laura","Football","Anime");

    }

    @Test
    void Test_insertion(){

        assertEquals("""
                USERNAME: INTERESTS
                ---------------------
                Laura: Football, Anime
                Juan: Football, Wrestling
                Enrique: Basketball, League of Legends
                Maria: Manga, Anime, League of Legends, WoW, CSgo
                Carlos: Anime, Shopping, Movies""",networkM.toString());

        assertThrows(IllegalArgumentException.class, () ->networkM.addUser(null,"Football","Wrestling"));
        assertThrows(IllegalArgumentException.class, () ->networkM.addUser("name",null,"Wrestling"));
        assertThrows(IllegalArgumentException.class, () ->networkM.addUser("name"));



    }

    @Test
    void Test_removal(){
        networkM.removeUser("Maria");
        assertEquals("""
                USERNAME: INTERESTS
                ---------------------
                Laura: Football, Anime
                Juan: Football, Wrestling
                Enrique: Basketball, League of Legends
                Carlos: Anime, Shopping, Movies""",networkM.toString());

        networkM.removeUser("Juan");

        assertEquals("""
                USERNAME: INTERESTS
                ---------------------
                Laura: Football, Anime
                Enrique: Basketball, League of Legends
                Carlos: Anime, Shopping, Movies""",networkM.toString());

        // WRONG NAME
        assertThrows(IllegalArgumentException.class, () ->networkM.addUser("name"));
        assertThrows(IllegalArgumentException.class, () ->networkM.addUser(null));

    }


    @Test
    void Test_getInterests(){
        TopicOfInterest[] array1= {new TopicOfInterest("Football"),new TopicOfInterest("Anime")};
        TopicOfInterest[] array2= {new TopicOfInterest("Anime"),new TopicOfInterest("Shopping"),
                new TopicOfInterest("Movies")};

        assertEquals(new ArrayList<>(Arrays.asList(array1)), networkM.getUserInterests("Laura"));
        assertEquals(new ArrayList<>(Arrays.asList(array2)), networkM.getUserInterests("Carlos"));
        assertThrows(IllegalArgumentException.class, () -> networkM.getUserInterests("name"));
        assertThrows(IllegalArgumentException.class, () -> networkM.getUserInterests(null));


    }

    @Test
    void Test_modify_Interests(){


        /* ADD INTEREST TEST*/
        TopicOfInterest[] array2_1= {new TopicOfInterest("Anime"),new TopicOfInterest("Shopping"),
                new TopicOfInterest("Movies"), new TopicOfInterest("Manga")};

        networkM.addInterest("Carlos","Manga");
        assertEquals(new ArrayList<>(Arrays.asList(array2_1)), networkM.getUserInterests("Carlos"));

        assertThrows(IllegalArgumentException.class, () -> networkM.addInterest("Carlos",null));
        assertThrows(IllegalArgumentException.class, () -> networkM.addInterest(null,"Interest"));


        /* REMOVE INTEREST TEST*/
        TopicOfInterest[] array2_2= {new TopicOfInterest("Shopping"), new TopicOfInterest("Movies")};
        networkM.removeInterest("Carlos","Anime");
        networkM.removeInterest("Carlos","Manga");
        assertEquals(new ArrayList<>(Arrays.asList(array2_2)), networkM.getUserInterests("Carlos"));

        assertThrows(IllegalArgumentException.class, () -> networkM.addInterest("Carlos",null));
        assertThrows(IllegalArgumentException.class, () -> networkM.addInterest(null,"Interest"));

    }

    @Test
    void Test_compareInterests(){
        /*TEST USERS INTERESTED IN SAME TOPIC*/
        String[] footballUsers = {"Laura","Juan"}, LoLUsers = {"Enrique", "Maria"}, AnimeUsers = {"Laura","Maria","Carlos"};

        assertEquals(new ArrayList<>(Arrays.asList(footballUsers)), networkM.getUsersByInterest("Football"));
        assertEquals(new ArrayList<>(Arrays.asList(LoLUsers)), networkM.getUsersByInterest("League of Legends"));
        assertEquals(new ArrayList<>(Arrays.asList(AnimeUsers)), networkM.getUsersByInterest("Anime"));

        assertEquals(new ArrayList<String>(),networkM.getUsersByInterest("Tennis"));
        assertThrows(IllegalArgumentException.class, () -> networkM.getUsersByInterest(null));


        /* TEST COMMON INTERESTS */
        networkM.addUser("Marcos","League of Legends", "Anime","Manga");

        TopicOfInterest[] commonMarcosMaria = {new TopicOfInterest("League of Legends"),new TopicOfInterest("Anime"),
                new TopicOfInterest("Manga")}, commonLauraJuan={new TopicOfInterest("Football")};

        assertEquals(new ArrayList<>(Arrays.asList(commonMarcosMaria)), networkM.getCommonInterests("Marcos","Maria"));
        assertEquals(new ArrayList<>(Arrays.asList(commonLauraJuan)), networkM.getCommonInterests("Laura","Juan"));

        assertThrows(IllegalArgumentException.class, () -> networkM.getCommonInterests(null,"Juan"));
        assertThrows(IllegalArgumentException.class, () -> networkM.getCommonInterests("Juan",null));
        assertThrows(IllegalArgumentException.class, () -> networkM.getCommonInterests("MariCarmen","Juan"));


    }

    @Test
    void Test_AllInterests(){
        TopicOfInterest[] topicList={new TopicOfInterest("Football"),new TopicOfInterest("Anime"),
                new TopicOfInterest("Wrestling"), new TopicOfInterest("Basketball"),
                new TopicOfInterest("League of Legends"), new TopicOfInterest("Manga"), new TopicOfInterest("WoW"),
                new TopicOfInterest("CSgo"), new TopicOfInterest("Shopping"), new TopicOfInterest("Movies")};

        assertEquals(new ArrayList<>(Arrays.asList(topicList)), networkM.getAllTopics());

        networkM.removeInterest("Maria","WoW");

        TopicOfInterest[] topicListWithoutWoW={new TopicOfInterest("Football"),new TopicOfInterest("Anime"),
                new TopicOfInterest("Wrestling"), new TopicOfInterest("Basketball"),
                new TopicOfInterest("League of Legends"), new TopicOfInterest("Manga"), new TopicOfInterest("CSgo"),
                new TopicOfInterest("Shopping"), new TopicOfInterest("Movies")};

        assertEquals(new ArrayList<>(Arrays.asList(topicListWithoutWoW)), networkM.getAllTopics());

    }



}
