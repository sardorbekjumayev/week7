package Aircraft;

import Users.Passenger;
import Enums.ReservationStatus;
import Notification.EmailNotification;
import Notification.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightReservation {
    private static final Map<String, FlightReservation> RESERVATIONS = new HashMap<>();

    private String reservationNumber;
    private FlightInstance flight;
    private Map<Passenger, FlightSeat> seatMap = new HashMap<>();
    private Date creationDate;
    private ReservationStatus status;

    public FlightReservation() {
        this.creationDate = new Date();
        this.status = ReservationStatus.REQUESTED;
    }

    public static FlightReservation fetchReservationDetails(String reservationNumber) {
        if (reservationNumber == null) {
            return null;
        }
        return RESERVATIONS.get(reservationNumber);
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
        if (reservationNumber != null) {
            RESERVATIONS.put(reservationNumber, this);
        }
    }

    public FlightInstance getFlight() {
        return flight;
    }

    public void setFlight(FlightInstance flight) {
        this.flight = flight;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(seatMap.keySet());
    }

    public boolean addPassenger(Passenger passenger) {
        if (passenger == null || seatMap.containsKey(passenger)) {
            return false;
        }
        seatMap.put(passenger, null);
        return true;
    }

    public boolean assignSeatToPassenger(Passenger passenger, FlightSeat seat) {
        if (passenger == null || seat == null) {
            return false;
        }

        if (!seatMap.containsKey(passenger)) {
            return false;
        }

        seatMap.put(passenger, seat);
        return true;
    }

    public boolean updateReservationStatus(ReservationStatus newStatus) {
        if (newStatus == null) {
            return false;
        }
        status = newStatus;
        sendReservationNotification();
        return true;
    }

    public boolean cancelReservation() {
        status = ReservationStatus.CANCELLED;
        sendCancelNotification();
        return true;
    }

    public boolean confirmReservation() {
        status = ReservationStatus.CONFIRMED;
        sendReservationNotification();
        return true;
    }

    private void sendReservationNotification() {
        Notification notification = new EmailNotification();
        notification.send();
    }

    private void sendCancelNotification() {
        Notification notification = new EmailNotification();
        notification.send();
    }
}