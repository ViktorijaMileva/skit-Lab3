import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConferenceTest {
    public static double TICKET_PRICE = 8.67;
    public static double AFFILIATE_DISCOUNT = 0.1;
    private Conference conference = new Conference(50);

    @Test
    public void addAttendeeToConferenceSuccessful(){
        Person person = new Person("Marko", "Markovski", Role.ORGANIZER, 40);
        conference.addAttendeeToConference(person);
        assertTrue(conference.getAttendees().contains(person));
    }

    @Test
    public void addAttendeeToConferenceDoubleCapacity(){
        Person person = new Person("Lana", "Markova", Role.FACULTY_EMPLOYEE, 30);
        conference.addAttendeeToConference(person);
        assertTrue(conference.doubleCapacity());
    }

    @Test
    public void addAttendeeToConferenceUnsuccessful(){
        Conference conference1 = new Conference(1);
        Person person1 = new Person("Darko", "Darkovski", Role.AFFILIATE, 25);

        for(int i = 0; i <= 10000; i++){
            conference1.addAttendeeToConference(person1);
        }
        Person person = new Person("Maja", "Majkova", Role.STUDENT, 20);
        assertFalse(conference1.addAttendeeToConference(person));
    }

    @Test
    public void doubleCapacityTest(){
        conference.doubleCapacity();
        assertEquals(100, conference.getCapacity());
    }

    @Test
    public void capacityCheck(){
        conference.doubleCapacity();
        assertFalse(conference.getCapacity() == 200);
    }


}
