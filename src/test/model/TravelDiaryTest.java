package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TravelDiaryTest {

    private TravelDiary travelDiary1;
    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    public void setup() {
        travelDiary1 = new TravelDiary("Name");

        flight1 = new Flight("AC1", "AIR CANADA", "Toronto",  5,
                "July 30", "6:00 AM");
        flight2 = new Flight("S1", "SWOOP", "Kelowna",  1,
                "July 31", "6:00 PM");
    }

    @Test
    void testAddFlight() {
        travelDiary1.addFlight(flight1);
        travelDiary1.addFlight(flight2);

        assertEquals(2, travelDiary1.getSize());
    }

    @Test
    void testRemoveFlight() {
        travelDiary1.addFlight(flight1);
        travelDiary1.addFlight(flight2);
        travelDiary1.removeFlight(flight1.getFlightNum());

        assertEquals(2, travelDiary1.getSize());
    }

    @Test
    void testGetSize() {
        travelDiary1.addFlight(flight1);
        travelDiary1.addFlight(flight2);

        assertEquals(2, travelDiary1.getSize());
    }

    @Test
    void testViewFlightTravelDiary() {
        travelDiary1.addFlight(flight1);
        assertTrue(travelDiary1.viewFlightTravelDiary());

    }

}
