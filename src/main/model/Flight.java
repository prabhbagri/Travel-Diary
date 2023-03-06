package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Calendar;

//Represents a single flight with a flight number, airline, destination, duration, departure date and time
public class Flight implements Writable {

    private String flightNum; //unique flight number
    private String airline; //name of airline of flight
    private String destination; //name of place flight is travelling to
    private int duration; //how long the flight is
    private String departureDate; //date the flight departs
    private String departureTime; //time the flight departs



//    public Flight(String flightNum, String airline, String destination) {
//        this.flightNum = flightNum;
//        this.airline = airline;
//        this.destination = destination;
//      //  this.departureDate = flight.getTime
//    }

    public Flight(String flightNum, String airline, String destination, int duration,
                  String departureDate, String departureTime) {
        this.flightNum = flightNum;
        this.airline = airline;
        this.destination = destination;
        this.duration = duration;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public String getAirline() {
        return airline;
    }

    public String getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Flight Number", this.flightNum);
        json.put("Airline", this.airline);
        json.put("Destination", this.destination);
        json.put("Duration", this.duration);
        json.put("Date", this.departureDate);
        json.put("Time", this.departureTime);
        return json;
    }

}
