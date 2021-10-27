package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HowartsTest {

    private School school, emptySchool;

    @BeforeEach
    void setUp() {
        school = new School();
        school.addStudent("Hermione","Granger", 18, 3, Resident.ResidentHouse.Gryffindor);
        school.addGhost("Bloody","Baron",109,1,Resident.ResidentHouse.Slytherin);
        school.addGamekeeper("Rubeus","Hagrid",45,2);
        school.addTeacher("Minerva", "McGonagall",52, 1, Teacher.subjects.Transfiguration);
        school.addTeacher("Severus", "Snape",42, 2, Teacher.subjects.Defence);
        school.addCaretaker("Argus","Filch",2,0);

        emptySchool = new School();
    }


    @Test
    void testInvalidMember(){

        assertThrows(IllegalArgumentException.class, () -> school.addStudent(null, "apellido", 17,3, Resident.ResidentHouse.Slytherin));
        assertThrows(IllegalArgumentException.class, () -> school.addGhost("nombre", null, 17,3, Resident.ResidentHouse.Gryffindor));
        assertThrows(IllegalArgumentException.class, () -> school.addStudent("nombre", "apellido", -3,3, Resident.ResidentHouse.Hufflepuff));
        assertThrows(IllegalArgumentException.class, () -> school.addStudent(null, "apellido", 17,-18, Resident.ResidentHouse.Ravenclaw));

    }

    @Test
    void testRewards() {

        assertEquals("""
                Hermione Granger ( Student of Gryffindor, 3 horcruxes ): 270.0 galleons
                Bloody Baron ( Ghost of Slytherin, 1 horcruxes ): 160.0 galleons
                Rubeus Hagrid ( Gamekeeper, 2 horcruxes ): 150.0 galleons
                Minerva McGonagall ( Teacher of Transfiguration, 1 horcruxes ): 50.0 galleons
                Severus Snape ( Teacher of Defence, 2 horcruxes ): 75.0 galleons
                Argus Filch ( Caretaker, 0 horcruxes ): 0.0 galleons
                The total reward for Hogwarts School is 705.0 galleons""", school.printRewards());

        assertEquals("There are no members on this school: The total reward for Hogwarts School is 0.0 galleons",emptySchool.printRewards());
    }

    @Test
    void testSalaries() {

        assertEquals("""
                Rubeus Hagrid ( Gamekeeper ): 180 galleons
                Minerva McGonagall ( Teacher of Transfiguration ): 400 galleons
                Severus Snape ( Teacher of Defence ): 500 galleons
                Argus Filch ( Caretaker ): 160 galleons
                The total payroll for Hogwarts School is 1240 galleons""", school.printSalaries());

        assertEquals("There is no staff on this school: The total payroll for Hogwarts School is 0 galleons",emptySchool.printSalaries());

    }

}

