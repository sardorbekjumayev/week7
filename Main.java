import Aircraft.*;
import Users.Customer;
import Users.Passenger;
import Users.SystemService;
import Enums.*;
import Payment.CreditCardTransaction;
import Payment.Payment;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Airline Management");

       
        Address address = new Address("New Street", "Tashkent", "UZ", "200100", "Uzbekistan");

        Airport tashkent = new Airport("Tashkent Airport", address, "TAS");
        Airport istambul = new Airport("Istambul Airport", address, "IST");

        Airline airline = new Airline("Uzbek Airways", "HY");

        Flight flight = new Flight();
        flight.setFlightNumber("HY301");
        flight.setDeparture(tashkent);
        flight.setArrival(istambul);
        flight.setDurationInMinutes(180);

        FlightInstance instance = new FlightInstance();
        instance.setDepartureTime(new Date());
        instance.setGate("A1");
        instance.setStatus(FlightStatus.SCHEDULED);

        flight.getInstances().add(instance);
        airline.addFlight(flight);

        Customer customer = new Customer("Sardorbek", address, "sardor@mail.com", "+998990022", "FH034");
        Passenger passenger = new Passenger();
        SystemService system = new SystemService();


        List<Flight> foundFlights = airline.searchFlights(tashkent, istambul);
        System.out.println("Flights found: " + foundFlights.size());
        System.out.println("__________________________");


        Itinerary itinerary = new Itinerary();
        boolean itineraryCreated = customer.createItinerary(itinerary);
        System.out.println("Create itinerary: " + itineraryCreated);
        System.out.println("__________________________");


        FlightReservation reservation = new FlightReservation();
        reservation.setReservationNumber("B005");
        reservation.setFlight(instance);


        boolean reservationCreated = itinerary.makeReservation(reservation);
        System.out.println("Create reservation: " + reservationCreated);
        System.out.println("__________________________");


        boolean passengerAdded = reservation.addPassenger(passenger);
        System.out.println("Add passenger: " + passengerAdded);


        FlightSeat seat = new FlightSeat("12A", SeatType.REGULAR, SeatClass.ECONOMY);
        seat.setFare(300.0);
        System.out.println("__________________________");

        boolean seatAssigned = reservation.assignSeatToPassenger(passenger, seat);
        System.out.println("Assign seat: " + seatAssigned);
        System.out.println("__________________________");

        Payment payment = new CreditCardTransaction(1, seat.getFare(), PaymentStatus.PENDING, "Sardor");
        boolean paymentDone = itinerary.makePayment(payment);
        System.out.println("Make payment: " + paymentDone);
        System.out.println("Payment status: " + payment.getStatus());
        System.out.println("__________________________");
        boolean reservationConfirmed = reservation.confirmReservation();
        System.out.println("Confirm reservation: " + reservationConfirmed);
        System.out.println("Reservation status: " + reservation.getStatus());
        System.out.println("__________________________");

        boolean notificationSent = system.sendItineraryNotification(itinerary);
        System.out.println("Send itinerary notification: " + notificationSent);
        System.out.println("__________________________");


        boolean itineraryCanceled = customer.cancelItinerary(itinerary);
        System.out.println("Cancel itinerary: " + itineraryCanceled);
        System.out.println("Payment status after cancel: " + payment.getStatus());
        System.out.println("Reservation status after cancel: " + reservation.getStatus());
    }
}