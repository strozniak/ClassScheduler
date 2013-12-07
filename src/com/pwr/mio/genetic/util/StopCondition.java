package com.pwr.mio.genetic.util;

import com.pwr.mio.genetic.model.Population;

/**
 * Created by Piotr on 07.12.13.
 */
public interface StopCondition {
    boolean isStopConditionFullfilled(Population schedulePopulation);
}
