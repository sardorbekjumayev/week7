package Users;

import Aircraft.FlightInstance;
import Enums.Address;

import java.util.List;

import java.util.ArrayList;

public class Crew extends Person {

    private List<FlightInstance> flights = new ArrayList<>();

    public Crew(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    public List<FlightInstance> getFlights() {
        return flights;
    }

    public List<FlightInstance> viewFlightInstances() {
        return flights;
    }
}
