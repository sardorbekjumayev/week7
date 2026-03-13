package Users;

import Aircraft.FlightInstance;
import Enums.Address;

import java.util.ArrayList;
import java.util.List;

public class Pilot extends Person {

    private List<FlightInstance> flights = new ArrayList<>();

    public Pilot(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    public List<FlightInstance> getFlights() {
        return flights;
    }

    public List<FlightInstance> viewFlightInstances() {
        return flights;
    }
}
