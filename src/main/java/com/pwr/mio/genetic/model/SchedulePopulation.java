package com.pwr.mio.genetic.model;

import com.pwr.mio.genetic.model.Population;
import com.pwr.mio.genetic.model.Schedule;
import com.pwr.mio.genetic.util.SelectionMethod;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Piotr on 07.12.13.
 */
public class SchedulePopulation implements Population {

    private List<Schedule> schedules;
    private final int POPULATION_SIZE;
    private final SelectionMethod selectionMethod;
    private final int COURSES = 10;
    private final int ROOMS = 5;
    private final int TIME_SLOTS = 5;

    public SchedulePopulation(int scheduleNumber, SelectionMethod selectionMethod) {
        this.POPULATION_SIZE = scheduleNumber;
        this.selectionMethod = selectionMethod;
        schedules = new LinkedList<Schedule>();
    }

    @Override
    public void generatePopulation() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < POPULATION_SIZE; i++) {
            Schedule schedule = new Schedule(TIME_SLOTS, ROOMS, COURSES, random);
            schedules.add(schedule);
            System.out.println(i+") " + schedule);
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
        //todo

    }

    @Override
    public void mutate() {

    }

    @Override
    public void chooseParents() {
        schedules = selectionMethod.chooseParents(schedules);
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
