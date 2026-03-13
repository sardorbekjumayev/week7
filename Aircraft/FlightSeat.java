package Aircraft;

import Enums.SeatClass;
import Enums.SeatType;

public class FlightSeat extends Seat {
    private double fare;
    private String reservationNumber;


    public FlightSeat(String seatNumber, SeatType type, SeatClass seatClass) {
        super(seatNumber, type, seatClass);
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
