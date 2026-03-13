package Users;

import Aircraft.Itinerary;
import Enums.Address;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String frequentFlyerNumber;
    private List<Itinerary> itineraries = new ArrayList<>();

    public Customer(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    public Customer(String name, Address address, String email, String phone, String frequentFlyerNumber) {
        super(name, address, email, phone);
        this.frequentFlyerNumber = frequentFlyerNumber;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public String getFrequentFlyerNumber() {
        return frequentFlyerNumber;
    }

    public void setFrequentFlyerNumber(String frequentFlyerNumber) {
        this.frequentFlyerNumber = frequentFlyerNumber;
    }

    public boolean createItinerary(Itinerary itinerary) {
        if (itinerary == null) {
            return false;
        }
        itinerary.setCustomerId(getName());
        return itineraries.add(itinerary);
    }

    public boolean cancelItinerary(Itinerary itinerary) {
        if (itinerary == null) {
            return false;
        }
        itinerary.cancelItinerary();
        return itineraries.remove(itinerary);
    }
}