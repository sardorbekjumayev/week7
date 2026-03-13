package Users;

import Aircraft.Itinerary;
import Aircraft.FlightInstance;
import Notification.EmailNotification;
import Notification.Notification;

public class SystemService {

    public boolean sendItineraryNotification(Itinerary itinerary) {
        if (itinerary == null) {
            return false;
        }

        System.out.println("Sending itinerary notification...");

        Notification notification = new EmailNotification();
        return notification.send();
    }

    public boolean sendFlightStatusUpdate(FlightInstance instance) {
        if (instance == null) {
            return false;
        }

        System.out.println("Sending flight status update notification...");

        Notification notification = new EmailNotification();
        return notification.send();
    }
}