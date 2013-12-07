package com.pwr.mio.genetic.util;

import com.pwr.mio.genetic.model.Population;

/**
 * Created by Piotr on 07.12.13.
 */
public class GenerationCountStopCondition implements StopCondition {
    private int counter = 20;
    @Override
    public boolean isStopConditionFullfilled(Population schedulePopulation) {
        return counter-- <= 0;
    }
}
