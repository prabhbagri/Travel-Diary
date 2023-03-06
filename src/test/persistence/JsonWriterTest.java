package persistence;

import model.Flight;
import model.TravelDiary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {

    @Test
    void testWriterInvalidFile() {
        try {
            TravelDiary td = new TravelDiary("My Travel Diary");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyTravelDiary() {
        try {
            TravelDiary td = new TravelDiary("My Travel Diary");
            JsonWriter writer = new JsonWriter("./data/testWriterMyTravelDiaryEmpty.json");
            writer.open();
            writer.write(td);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterMyTravelDiaryEmpty.json");
            td = reader.read();
            assertEquals("My Travel Diary", td.getName());
            assertEquals(0, td.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            TravelDiary td = new TravelDiary("My Travel Diary");
            td.addFlight(new Flight("F1", "FLAIR", "Calgary",
                    2, "August 01", "6:00 PM"));
            td.addFlight(new Flight("F2", "FLAIR", "Edmonton", 1,
                    "August 01", "8:00 AM"));
            JsonWriter writer = new JsonWriter("./data/testWriterMyTravelDiary.json");
            writer.open();
            writer.write(td);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterMyTravelDiary.json");
            td = reader.read();
            assertEquals("My Travel Diary", td.getName());
            assertEquals(2, td.getSize());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
