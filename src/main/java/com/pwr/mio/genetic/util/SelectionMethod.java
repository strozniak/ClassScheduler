package com.pwr.mio.genetic.util;

import com.pwr.mio.genetic.model.Schedule;

import java.util.List;

/**
 * Created by Piotr on 07.12.13.
 */
public interface SelectionMethod {
    List<Schedule> chooseParents(List<Schedule> schedules, int numberOfSelectedSchedules);
}
