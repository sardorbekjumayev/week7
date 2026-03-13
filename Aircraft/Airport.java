package Aircraft;

import Enums.Address;

import java.util.List;
import java.util.ArrayList;

public class Airport {

    private String name;
    private Address address;
    private String code;

    
    private List<Flight> flights;

    public Airport(String name, Address address, String code) {
        this.name = name;
        this.address = address;
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}

