package Aircraft;

import Payment.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Itinerary {

    private String customerId;
    private Airport startingAirport;
    private Airport finalAirport;
    private Date creationDate;
    private List<FlightReservation> reservations = new ArrayList<>();
    private Payment payment;

    public Itinerary() {
        this.creationDate = new Date();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<FlightReservation> getReservations() {
        return reservations;
    }

    public boolean makeReservation() {
        return !reservations.isEmpty();
    }

    public boolean makeReservation(FlightReservation reservation) {
        if (reservation == null) {
            return false;
        }
        return reservations.add(reservation);
    }

    public boolean makePayment() {
        if (payment == null) {
            return false;
        }
        return payment.makeTransaction();
    }

    public boolean makePayment(Payment payment) {
        if (payment == null) {
            return false;
        }
        this.payment = payment;
        return payment.makeTransaction();
    }

    public boolean mkePayment(Payment payment) {
        return makePayment(payment);
    }

    public boolean cancelItinerary() {
        boolean changed = false;

        for (FlightReservation reservation : reservations) {
            reservation.cancelReservation();
            changed = true;
        }

        if (payment != null) {
            payment.refundPayment();
            changed = true;
        }

        return changed;
    }
}