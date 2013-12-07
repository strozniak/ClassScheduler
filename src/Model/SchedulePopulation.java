package Model;

import Model.Population;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Piotr on 07.12.13.
 */
public class SchedulePopulation implements Population {

    private final List<Schedule> schedules;
    private final int POPULATION_SIZE;
    private final int COURSES = 10;
    private final int ROOMS = 3;
    private final int TIME_SLOTS = 6;

    public SchedulePopulation(int scheduleNumber) {
        this.POPULATION_SIZE = scheduleNumber;
        schedules = new LinkedList<Schedule>();
    }

    @Override
    public void generatePopulation() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            schedules.add(new Schedule(TIME_SLOTS,ROOMS,COURSES));
        }
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
