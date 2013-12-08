package com.pwr.mio.genetic.model;

import java.util.Random;

/**
 * Created by Piotr on 07.12.13.
 */
public class Schedule {

    public static final int MAX_GENOME_VALUE = 20;
    private final int TIME_SLOTS;
    private final int ROOMS;
    private final int COURSES;
    private final Random RANDOM;
    private Course[] courses;
    private int genomeValue;

    public Schedule(int timeSlots, int rooms, int courses, Random random) {
        TIME_SLOTS = timeSlots;
        ROOMS = rooms;
        COURSES = courses;
        RANDOM = random;

        initSchedule();
        generateGeneRandomValues();
    }

    public void estimate() {
        genomeValue = MAX_GENOME_VALUE;
        int[][] schedule = new int[ROOMS][TIME_SLOTS];
        boolean hasConflicts = false;
        for (int i = 0; i < COURSES; i++) {
            int room = courses[i].room;
            int time = courses[i].time;
            if (schedule[room][time] == 1) {
                genomeValue -= 2;
//                System.out.println("conflict, time: " + time + ", room: " + room);
            } else {
                schedule[room][time] = 1;
            }
        }
        genomeValue -= getGaps(schedule);
    }

    private boolean hasConflict(int[][] schedule) {

        return false;
    }

    private int getGaps(int[][] schedule) {
        int gaps = 0;
        for (int i = 0; i < ROOMS; i++) {
            int minIdx = getFirstCourseTime(schedule[i]);
            int maxIdx = getLastCourseTime(schedule[i]);
            for (int j = minIdx; j < maxIdx; j++) {
                if (schedule[i][j] != 1) {
                    gaps++;
                }
            }
        }
        return gaps;
    }

    private int getLastCourseTime(int[] roomCourses) {
        int i = TIME_SLOTS - 1;
        while (i > 0 && roomCourses[i] != 1) {
            i--;
        }
        return i;
    }

    private int getFirstCourseTime(int[] roomCourses) {
        int i = 0;
        while (i < TIME_SLOTS && roomCourses[i] != 1) {
            i++;
        }
        return i;
    }

    private void generateGeneRandomValues() {
        for (int i = 0; i < COURSES; i++) {
            int randomTime = RANDOM.nextInt(TIME_SLOTS);
            int randomRoom = RANDOM.nextInt(ROOMS);

            courses[i].room = randomRoom;
            courses[i].time = randomTime;
        }

        estimate();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Genome = [ ");
        for (int i = 0; i < COURSES; i++) {
            sb.append(courses[i].time + " " + courses[i].room + " | ");
        }
        sb.append(" ] Eval: " + getGenomeValue());

        return sb.toString();
    }

    private void initSchedule() {
        courses = new Course[COURSES];
        for (int i = 0; i < COURSES; i++) {
            courses[i] = new Course();
        }
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getGenomeValue() {
        return genomeValue;
    }
}
