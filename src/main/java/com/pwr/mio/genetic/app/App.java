package com.pwr.mio.genetic.app;

import com.pwr.mio.genetic.model.Population;
import com.pwr.mio.genetic.model.Schedule;
import com.pwr.mio.genetic.model.SchedulePopulation;
import com.pwr.mio.genetic.util.GenerationCountStopCondition;
import com.pwr.mio.genetic.util.RoulleteSelection;
import com.pwr.mio.genetic.util.SelectionMethod;
import com.pwr.mio.genetic.util.StopCondition;

/**
 * Created by Piotr on 7.12.13.
 */
public class App {

    public static final int SCHEDULE_NUMBER = 100;

    public static void main(String[] args) {

        SelectionMethod selection = new RoulleteSelection();
        Population schedulePopulation = new SchedulePopulation(SCHEDULE_NUMBER, selection);
        schedulePopulation.generatePopulation();

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.setPopulation(schedulePopulation);

        StopCondition populationCount = new GenerationCountStopCondition();
        geneticAlgorithm.setStopCondition(populationCount);

        // generates/evaluetes... new population till stop condition
        geneticAlgorithm.generateNextGenerations();

        Schedule bestSchedule = geneticAlgorithm.getBestSchedule();

        print(bestSchedule);

    }

    private static void print(Schedule bestSchedule) {

    }
}
