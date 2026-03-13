package Aircraft;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Airline {
    private String name;
    private String code;
    private List<Flight> flights;

    public Airline() {
        this.flights = new ArrayList<>();
    }

    public Airline(String name, String code) {
        this.name = name;
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> searchFlights(Airport departure, Airport arrival) {
        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getDeparture() != null && flight.getArrival() != null
                    && flight.getDeparture().equals(departure)
                    && flight.getArrival().equals(arrival)) {
                result.add(flight);
            }
        }

        return result;
    }

    public List<Flight> searchFlights(Date date, Airport departure, Airport arrival) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : searchFlights(departure, arrival)) {
            if (!flight.findInstancesByDate(date).isEmpty()) {
                result.add(flight);
            }
        }
        return result;
    }

    public void addFlight(Flight flight) {
    }
}
