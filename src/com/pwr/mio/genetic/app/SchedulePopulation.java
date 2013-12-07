package com.pwr.mio.genetic.app;

import com.pwr.mio.genetic.model.Population;
import com.pwr.mio.genetic.model.Schedule;
import com.pwr.mio.genetic.util.SelectionMethod;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Piotr on 07.12.13.
 */
public class SchedulePopulation implements Population {

    private List<Schedule> schedules;
    private final int POPULATION_SIZE;
    private final SelectionMethod selectionMethod;
    private final int COURSES = 10;
    private final int ROOMS = 3;
    private final int TIME_SLOTS = 6;

    public SchedulePopulation(int scheduleNumber, SelectionMethod selectionMethod) {
        this.POPULATION_SIZE = scheduleNumber;
        this.selectionMethod = selectionMethod;
        schedules = new LinkedList<Schedule>();
    }

    @Override
    public void generatePopulation() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            schedules.add(new Schedule(TIME_SLOTS, ROOMS, COURSES));
        }
    }

    @Override
    public Schedule getBest() {
        Schedule bestSchedule = schedules.get(1);
        for (Schedule schedule : schedules) {
            if (schedule.getGenomeValue() > bestSchedule.getGenomeValue()) {
                bestSchedule = schedule;
            }
        }
        return bestSchedule;
    }

    @Override
    public void estimatePopulation() {
        for (Schedule schedule : schedules) {
            schedule.estimate();
        }
    }

    @Override
    public void cross() {

    }

    @Override
    public void mutate() {

    }

    @Override
    public void chooseParents() {

    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
