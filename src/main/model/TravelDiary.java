package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Iterator;

//Represents a travel diary list of flights
public class TravelDiary implements Writable {
    private ArrayList<Flight> travelDiary;
    private String name;

    //EFFECTS: an arraylist of flights
    public TravelDiary(String name) {
        this.name = name;
        travelDiary = new ArrayList<Flight>();
    }

    //MODIFIES: this
    //EFFECTS: adds flight to the travel diary
    public void addFlight(Flight flight) {
        travelDiary.add(flight);
        String eventMsg = flight.getDestination();
        eventMsg += " added in Travel Diary";
        EventLog.getInstance()
                .logEvent(new Event(eventMsg));
    }



    //MODIFIES: this
    //EFFECTS: removes flight from the travel diary
    public void removeFlight(String flightNum) {
        travelDiary.remove(flightNum);
        String eventMsg = "Removed flight from Travel Diary";
        EventLog.getInstance()
                .logEvent(new Event(eventMsg));
    }

//    //EFFECTS: returns flight if flight number matches otherwise returns null
//    public Flight searchFlight(int flightNum) {
//        for (Flight flight : travelDiary) {
//            if (flightNum == flight.getFlightNum()) {
//                return flight;
//            }
//
//        }
//        return null;
//    }

    public ArrayList<Flight> getFlights() {
        return this.travelDiary;
    }

    //EFFECTS: return size of travel diary list
    public int getSize() {
        return travelDiary.size();
    }

    public String getName() {
        return name;
    }


    //EFFECTS: prints flights already in travel diary
    public boolean viewFlightTravelDiary() {
        boolean bsuccess = false;
        for (Flight flight : travelDiary) {
            String fn = flight.getFlightNum();
            String al = flight.getAirline();
            String fd = flight.getDestination();
            int dur = flight.getDuration();
            String dd = flight.getDepartureDate();
            String dt = flight.getDepartureTime();

            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", fn, al, fd, dur, dd, dt);
            bsuccess = true;
        }
        return bsuccess;
    }


    // MODIFIES: this
    // EFFECTS: closes events
    public void closeAction() {
        for (Event e : EventLog.getInstance()) {
            System.out.println(e);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes flights from the list of flights
    public void removeFlightTravelDiary(int index) {
        this.travelDiary.remove(index);
        String eventMsg = "Removed flight from Travel Diary";
        EventLog.getInstance()
                .logEvent(new Event(eventMsg));
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("Travel Diary", this.travelToJson());
        return json;
    }

    // EFFECTS: returns flights in travel diary as a JSON array
    private JSONArray travelToJson() {
        JSONArray jsonArray = new JSONArray();
        Iterator var2 = this.travelDiary.iterator();

        while (var2.hasNext()) {
            Flight f = (Flight) var2.next();
            jsonArray.put(f.toJson());
        }

        return jsonArray;
    }


}
