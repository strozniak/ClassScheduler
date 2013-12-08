package com.pwr.mio.genetic.app;

import com.pwr.mio.genetic.model.Population;
import com.pwr.mio.genetic.model.Schedule;
import com.pwr.mio.genetic.util.StopCondition;

/**
 * Created by Piotr on 07.12.13.
 */
public class GeneticAlgorithm {
    private Population schedulePopulation;
    private StopCondition populationCount;

    public void setPopulation(Population schedulePopulation) {

        this.schedulePopulation = schedulePopulation;
    }

    public void setStopCondition(StopCondition populationCount) {

        this.populationCount = populationCount;
    }

    public void generateNextGenerations() {
        schedulePopulation.estimatePopulation();
        while (!populationCount.isStopConditionFullfilled(schedulePopulation)) {
            schedulePopulation.chooseParents();
            schedulePopulation.cross();
            schedulePopulation.mutate();
        }
    }

    public Schedule getBestSchedule() {
       return schedulePopulation.getBest();
    }
}
