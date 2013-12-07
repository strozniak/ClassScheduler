package com.pwr.mio.genetic.util;

import com.pwr.mio.genetic.model.Schedule;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Piotr on 07.12.13.
 */
public class RoulleteSelection implements SelectionMethod {
    private Random random = new Random(System.currentTimeMillis());
    private int[] pie;


    @Override
    public List<Schedule> chooseParents(List<Schedule> schedules, int numberOfSelectedSchedules) {
        List<Schedule> selectedParents = new LinkedList<Schedule>();
        int sum = countSum(schedules);
        int perc = 0;
        pie = new int[schedules.size()];
        for (int i = 0; i < schedules.size(); i++) {
            perc += Math.round((schedules.get(i).getGenomeValue()/sum) * 100);
            pie[i] = perc;
        }

        for(int i = 0; i < numberOfSelectedSchedules;i++) {
            int rndIndex = random.nextInt(100);
            int j = 0;
            while (j <  pie.length && rndIndex < pie[j]) {
                ++j;
            }
            selectedParents.add(schedules.get(j--));
        }

        return selectedParents;
    }

    private int countSum(List<Schedule> schedules) {
        int sum = 0;
        for(Schedule schedule:schedules) {
            sum += schedule.getGenomeValue();
        }
        return sum;
    }

}
