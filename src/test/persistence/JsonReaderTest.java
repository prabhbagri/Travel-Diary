package persistence;

import model.Flight;
import model.TravelDiary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            TravelDiary td = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderMyTravelDiaryEmpty.json");
        try {
            TravelDiary td = reader.read();
            Assertions.assertEquals("My Travel Diary", td.getName());
            Assertions.assertEquals(0, td.getSize());

        } catch (IOException e) {
            Assertions.fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderMyTravelDiary.json");

        try {
            TravelDiary td = reader.read();
            td.addFlight(new Flight("F1", "FLAIR", "Calgary",
                    2, "August 01", "6:00 PM"));
            Assertions.assertEquals("My Travel Diary", td.getName());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
