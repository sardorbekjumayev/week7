package Users;

import Aircraft.Aircraft;
import Aircraft.Airport;
import Aircraft.Flight;
import Aircraft.FlightInstance;
import Enums.Address;
import Schedules.CustomSchedule;
import Schedules.WeeklySchedule;

import java.util.List;

public class Admin extends Person {

    public Admin(String name, Address address, String email, String phone) {
        super(name, address, email, phone);
    }

    public boolean addAircraft(Aircraft aircraft, List<Aircraft> aircrafts) {
        if (aircraft == null || aircrafts == null) {
            return false;
        }
        return aircrafts.add(aircraft);
    }

    public boolean modifyAircraft(Aircraft aircraft, String name, String model, int year) {
        if (aircraft == null) {
            return false;
        }

        aircraft.setName(name);
        aircraft.setModal(model);
        aircraft.setManufacturingYear(year);

        return true;
    }

    public boolean addFlight(Flight flight, List<Flight> flights) {
        if (flight == null || flights == null) {
            return false;
        }
        return flights.add(flight);
    }

    public boolean modifyFlight(Flight flight, Airport departure, Airport arrival) {
        if (flight == null) {
            return false;
        }

        flight.setDeparture(departure);
        flight.setArrival(arrival);

        return true;
    }

    public boolean cancelFlightInstance(FlightInstance instance) {
        if (instance == null) {
            return false;
        }

        instance.cancel();
        return true;
    }

    public boolean cancelFlight(Flight flight, SystemService systemService) {
        if (flight == null) {
            return false;
        }

        flight.cancel();

        if (systemService != null) {
            for (FlightInstance instance : flight.getFlightInstances()) {
                systemService.sendFlightStatusUpdate(instance);
            }
        }

        return true;
    }

    public boolean assignPilot(Pilot pilot, FlightInstance instance) {
        if (pilot == null || instance == null) {
            return false;
        }

        pilot.getFlights().add(instance);
        return true;
    }

    public boolean assignCrew(Crew crew, FlightInstance instance) {
        if (crew == null || instance == null) {
            return false;
        }

        crew.getFlights().add(instance);
        return true;
    }

    public FlightInstance viewFlightInstance(FlightInstance instance) {
        return instance;
    }

    public boolean addWeeklySchedule(Flight flight, WeeklySchedule schedule) {
        if (flight == null) {
            return false;
        }
        return flight.addFlightSchedule(schedule);
    }

    public boolean addCustomSchedule(Flight flight, CustomSchedule schedule) {
        if (flight == null) {
            return false;
        }
        return flight.addFlightSchedule(schedule);
    }

    public boolean modifyWeeklySchedule(Flight flight, int index, WeeklySchedule schedule) {
        if (flight == null) {
            return false;
        }
        return flight.modifyWeeklySchedule(index, schedule);
    }

    public boolean modifyCustomSchedule(Flight flight, int index, CustomSchedule schedule) {
        if (flight == null) {
            return false;
        }
        return flight.modifyCustomSchedule(index, schedule);
    }
}
