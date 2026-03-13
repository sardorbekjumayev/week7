package Aircraft;

import Enums.SeatClass;
import Enums.SeatType;

public class Seat {
    private String seatNumber;
    public SeatType type;
    public SeatClass seatClass;


    public Seat(String seatNumber, SeatType type, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.seatClass = seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return type;
    }

    public void setSeatType(SeatType type) {
        this.type = type;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }
}
