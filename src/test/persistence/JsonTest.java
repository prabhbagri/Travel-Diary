package persistence;

import model.TravelDiary;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTravelDiary(String name, TravelDiary td) {
        assertEquals(name, td.getName());
    }
}
