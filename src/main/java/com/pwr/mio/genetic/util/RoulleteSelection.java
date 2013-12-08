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
    public List<Schedule> chooseParents(List<Schedule> schedules) {
        List<Schedule> selectedParents = new LinkedList<Schedule>();
        int sum = countSum(schedules);
        System.out.println("sum="+sum);
        int perc = 0;
        pie = new int[schedules.size()];
        for (int i = 0; i < schedules.size(); i++) {
            System.out.println("genome value = "+schedules.get(i).getGenomeValue());
            float div = ((float)schedules.get(i).getGenomeValue()) / sum;
            System.out.println("div="+div);
            perc +=div * 100;
            System.out.println("pie prtg: "+perc);
            pie[i] = perc;
        }

        StringBuffer sb = new StringBuffer();
        sb.append("Choosen parents: ");
        for (int i = 0; i < schedules.size(); i++) {
            int rndIndex = random.nextInt(100);
            System.out.println("random = "+rndIndex);
            int j = 0;

            while (j < pie.length && rndIndex > pie[j]) {
                ++j;
            }
            if (j== pie.length) {
                j--;
            }
            sb.append("\ndodano: "+j + ", ");
            selectedParents.add(schedules.get(j));
        }
        System.out.println(sb);

        return selectedParents;
    }

    private int countSum(List<Schedule> schedules) {
        int sum = 0;
        for (Schedule schedule : schedules) {
            sum += schedule.getGenomeValue();
        }
        return sum;
    }

}
