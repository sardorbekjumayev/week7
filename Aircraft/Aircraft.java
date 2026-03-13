package Aircraft;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private String name;
    private String model;
    private int manufacturingYear;
    private List<Seat> seats;
    private List<FlightInstance> flights;

    public Aircraft() {
        this.seats = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public Aircraft(String name, String model, int manufacturingYear) {
        this.name = name;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.seats = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<FlightInstance> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightInstance> flights) {
        this.flights = flights;
    }

    
    public String getModal() {
        return getModel();
    }

    public void setModal(String modal) {
        setModel(modal);
    }
}
