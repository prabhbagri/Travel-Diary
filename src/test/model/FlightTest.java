package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {

    private Flight flight1;

    @BeforeEach
    public void setup() {
        flight1 = new Flight("AC1", "AIR CANADA", "Toronto",  5,
                "July 30", "6:00 AM");
    }

    @Test
    void testConstructor() {
        assertEquals("AC1", flight1.getFlightNum());
        assertEquals("AIR CANADA", flight1.getAirline());
        assertEquals("Toronto", flight1.getDestination());
        assertEquals(5, flight1.getDuration());
        assertEquals("July 30", flight1.getDepartureDate());
        assertEquals("6:00 AM", flight1.getDepartureTime());
    }
}
