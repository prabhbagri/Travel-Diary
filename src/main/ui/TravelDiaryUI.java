package ui;

import model.Flight;
import model.TravelDiary;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelDiaryUI extends javax.swing.JFrame {

    //Travel Diary application
    private static final String JSON_STORE = "./data/MyTravelDiary.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static ArrayList<Flight> flights;
    private Scanner input;
    private TravelDiary td;

    //EFFECTS: runs the MyTravelDiary application
    public TravelDiaryUI() {
        flights = new ArrayList<>();
        td = new TravelDiary("My Travel Diary");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        input = new Scanner(System.in);
        runTravelDiary();
        loadTravelDiary();
    }





    //MODIFIES: this
    //EFFECTS: processes user input
    private void runTravelDiary() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("f")) {
            searchFlights();
        } else if (command.equals("a")) {
            addFlights();
        } else if (command.equals("r")) {
            removeFlight();
        } else if (command.equals("v")) {
            viewFlight();
        } else if (command.equals("t")) {
            viewMyTravelDiary();
        } else if (command.equals("s")) {
            saveTravelDiary();
        } else if (command.equals("l")) {
            loadTravelDiary();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes flights
    private void init() {
        flights.add(new Flight("F1", "FLAIR", "Calgary",
                2, "August 01", "6:00 PM"));
        flights.add(new Flight("F2", "FLAIR", "Edmonton", 1,
                "August 01", "8:00 AM"));
        flights.add(new Flight("F3", "FLAIR", "Kelowna", 1,
                "August 01", "8:00 AM"));
        flights.add(new Flight("AC1", "AIR CANADA", "Toronto", 5,
                "August 02", "10:00 AM"));
        flights.add(new Flight("AC2", "AIR CANADA", "Toronto", 5,
                "August 03", "9:00 PM"));
        flights.add(new Flight("AC3", "AIR CANADA", "Winnipeg", 3,
                "August 03", "5:00 PM"));
        flights.add(new Flight("W1", "WESTJET", "Toronto", 5,
                "August 04", "4:00 AM"));
        flights.add(new Flight("W2", "WESTJET", "Saskatchewan", 6,
                "August 04", "11:00 PM"));
        flights.add(new Flight("S1", "SWOOP", "Nunavut", 7,
                "August 06", "1:00 PM"));
        flights.add(new Flight("S2", "SWOOP", "Montreal", 5,
                "August 06", "2:00 AM"));
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    //EFFECTS: displays menu of options for flights to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tf -> search flights");
        System.out.println("\ta -> add flights to travel diary");
        System.out.println("\tr -> remove flights from travel diary");
        System.out.println("\tv -> view all flights flying from YVR this week");
        System.out.println("\tt -> view current flights in My Travel Diary");
        System.out.println("\ts -> save current flights in My Travel Diary");
        System.out.println("\tl -> load current flights in My Travel Diary");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: this
    //EFFECTS: searches for flights under the given airline
    private void searchFlights() {
        System.out.print("Enter Airline: ");
        String cmd = null;
        input = new Scanner(System.in);
        cmd = input.nextLine().toUpperCase();

        boolean bsuccess = false;

        for (Flight flight : flights) {
            if (cmd.equals(flight.getAirline())) {

                String fn = flight.getFlightNum();
                String al = flight.getAirline();
                String fd = flight.getDestination();
                int dur = flight.getDuration();
                String dd = flight.getDepartureDate();
                String dt = flight.getDepartureTime();
                //display flights
                System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", fn, al, fd, dur, dd, dt);
                bsuccess = true;
            }

        }
        // flight not found
        if (!bsuccess) {
            System.out.println("Flight not found");
        }

    }

    //MODIFIES: this
    //EFFECTS: adds flights to users travel diary from flight number
    private void addFlights() {
        System.out.print("Enter Flight#: ");
        input = new Scanner(System.in);
        String cmd = input.next();
        boolean bsuccess = false;
        for (Flight flight : flights) {
            if (cmd == flight.getFlightNum()) {
                td.addFlight(flight);
                bsuccess = true;
                break;
            }
        }
        if (!bsuccess) {
            System.out.println("Could not add flight " + cmd);
        } else {
            System.out.println("Flight successfully added to My Travel Diary!");
        }
    }


    //MODIFIES: this
    //EFFECTS: removes flight from users travel diary from flight number
    private void removeFlight() {
        System.out.print("Enter Flight#: ");
        input = new Scanner(System.in);
        String cmd = input.next();
        boolean bsuccess = false;
        for (Flight flight : flights) {
            if (cmd == flight.getFlightNum()) {
              //  td.removeFlight(flightNum);
                bsuccess = true;
                break;
            }
        }
        if (!bsuccess) {
            System.out.println("Could not remove flight " + cmd);
        } else {
            System.out.println("Flight successfully removed from My Travel Diary!");
        }
    }


    //EFFECTS: prints all domestic flights travelling this week from YVR
    private void viewFlight() {
        for (Flight flight : flights) {
            String fn = flight.getFlightNum();
            String al = flight.getAirline();
            String fd = flight.getDestination();
            int dur = flight.getDuration();
            String dd = flight.getDepartureDate();
            String dt = flight.getDepartureTime();

            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", fn, al, fd, dur, dd, dt);
        }
    }

    //EFFECTS: prints all domestic flights in users travel diary
    private void viewMyTravelDiary() {
        td.viewFlightTravelDiary();
    }

    // EFFECTS: saves the workroom to file
    private void saveTravelDiary() {
        try {
            jsonWriter.open();
            jsonWriter.write(td);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this,
                    "Saved " + this.td.getName() + " to " + "./data/BroadwayShows.json");
            System.out.println("Saved " + td.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadTravelDiary() {
        try {
            td = jsonReader.read();
            System.out.println("Loaded " + td.getName() + " from " + JSON_STORE);
            td.viewFlightTravelDiary();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

