package Users;

import Aircraft.Itinerary;
import Enums.Address;

import java.util.ArrayList;
import java.util.List;

public class FrontDeskOfficer extends Person {
    private List<Itinerary> itineraries = new ArrayList<>();

    public FrontDeskOfficer(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    public boolean createItinerary(Itinerary itinerary) {
        if (itinerary == null) {
            return false;
        }
        return itineraries.add(itinerary);
    }
    public boolean cancelItinerary(Itinerary itinerary) {
        if (itinerary == null) {
            return false;
        }
        return itineraries.remove(itinerary);
    }
    public List<Itinerary> viewItineraries() {
        return itineraries;
    }
}
