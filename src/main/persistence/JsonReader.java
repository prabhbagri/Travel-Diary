package persistence;

import model.Flight;
import model.TravelDiary;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads travel diary from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TravelDiary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTravelDiary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses travel diary from JSON object and returns it
    private TravelDiary parseTravelDiary(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        TravelDiary td = new TravelDiary(name);
        addFlights(td, jsonObject);
        return td;
    }

    // MODIFIES: td
    // EFFECTS: parses flights from JSON object and adds them to travel diary
    private void addFlights(TravelDiary td, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Travel Diary");
        for (Object json : jsonArray) {
            JSONObject nextFlight = (JSONObject) json;
            addFlight(td, nextFlight);
        }
    }

    // MODIFIES: td
    // EFFECTS: parses flights from JSON object and adds it to travel diary
    private void addFlight(TravelDiary td, JSONObject jsonObject) {

        String flightNum = jsonObject.getString("Flight Number");
        String airline = jsonObject.getString("Airline");
        String destination = jsonObject.getString("Destination");
        int duration = jsonObject.getInt("Duration");
        String departureDate = jsonObject.getString("Date");
        String departureTime = jsonObject.getString("Time");

        Flight flight = new Flight(flightNum, airline, destination, duration,
                departureDate, departureTime);
        td.addFlight(flight);
    }
}
