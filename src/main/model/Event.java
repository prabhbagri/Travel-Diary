package model;

import java.util.Calendar;
import java.util.Date;

public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String flightNum;

    /**
     * Creates an event with the given description
     * and the current date/time stamp.
     *
     * @param flightNum a description of the event
     */
    public Event(String flightNum) {
        dateLogged = Calendar.getInstance().getTime();
        this.flightNum = flightNum;
    }

    /**
     * Gets the date of this event (includes time).
     *
     * @return the date of the event
     */
    public Date getDate() {
        return dateLogged;
    }

    /**
     * Gets the description of this event.
     *
     * @return the description of the event
     */
    public String getFlightNum() {
        return flightNum;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }

        model.Event otherEvent = (model.Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged)
                &&
                this.flightNum.equals(otherEvent.flightNum));
    }

    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + flightNum.hashCode());
    }

    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + flightNum;
    }
}


