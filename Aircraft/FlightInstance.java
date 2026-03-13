package Aircraft;

import Enums.FlightStatus;

import java.util.Date;

public class FlightInstance {
    private Date departureTime;
    private String gate;
    private FlightStatus status;
    private Aircraft aircraft;

    public FlightInstance(Date departureTime, String gate, FlightStatus status, Aircraft aircraft) {
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
        this.aircraft = aircraft;
    }

    public FlightInstance() {

    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public boolean cancel() {
        this.status = FlightStatus.CANCELLED;
        return true;
    }

    public void updateStatus(FlightStatus status) {
        this.status = status;
    }
}
