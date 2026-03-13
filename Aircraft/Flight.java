package Aircraft;

import Enums.FlightStatus;
import Schedules.CustomSchedule;
import Schedules.WeeklySchedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Flight {
    private String flightNumber;
    private Airport departure;
    private Airport arrival;
    private int durationInMinutes;

    private List<FlightInstance> instances = new ArrayList<>();
    private List<WeeklySchedule> weeklySchedules = new ArrayList<>();
    private List<CustomSchedule> customSchedules = new ArrayList<>();

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public List<FlightInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<FlightInstance> instances) {
        this.instances = instances;
    }

    public boolean cancel() {
        for (FlightInstance instance : instances) {
            instance.cancel();
        }
        return true;
    }

    public boolean addFlightSchedule(WeeklySchedule schedule) {
        if (schedule == null) {
            return false;
        }
        return weeklySchedules.add(schedule);
    }

    public boolean addFlightSchedule(CustomSchedule schedule) {
        if (schedule == null) {
            return false;
        }
        return customSchedules.add(schedule);
    }

    public boolean modifyWeeklySchedule(int index, WeeklySchedule newSchedule) {
        if (index < 0 || index >= weeklySchedules.size() || newSchedule == null) {
            return false;
        }
        weeklySchedules.set(index, newSchedule);
        return true;
    }

    public boolean modifyCustomSchedule(int index, CustomSchedule newSchedule) {
        if (index < 0 || index >= customSchedules.size() || newSchedule == null) {
            return false;
        }
        customSchedules.set(index, newSchedule);
        return true;
    }

    public List<WeeklySchedule> getWeeklySchedules() {
        return weeklySchedules;
    }

    public List<CustomSchedule> getCustomSchedules() {
        return customSchedules;
    }

    public List<FlightInstance> getFlightInstances() {
        return instances;
    }

    public List<FlightInstance> findInstancesByDate(Date date) {
        List<FlightInstance> result = new ArrayList<>();
        if (date == null) {
            return result;
        }

        Calendar expected = Calendar.getInstance();
        expected.setTime(date);

        for (FlightInstance instance : instances) {
            if (instance.getDepartureTime() == null) {
                continue;
            }

            Calendar actual = Calendar.getInstance();
            actual.setTime(instance.getDepartureTime());

            if (expected.get(Calendar.YEAR) == actual.get(Calendar.YEAR)
                    && expected.get(Calendar.DAY_OF_YEAR) == actual.get(Calendar.DAY_OF_YEAR)) {
                result.add(instance);
            }
        }

        return result;
    }

    public void updateAllInstanceStatuses(FlightStatus status) {
        for (FlightInstance instance : instances) {
            instance.updateStatus(status);
        }
    }
}
