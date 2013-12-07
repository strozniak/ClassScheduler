package Model;

import Model.Course;

import java.util.Random;

/**
 * Created by Piotr on 07.12.13.
 */
public class Schedule {

    private final int TIME_SLOTS;
    private final int ROOMS;
    private final int COURSES;
    private Random random;
    private Course[] courses;


    public Schedule(int timeSlots, int rooms, int courses) {
        TIME_SLOTS = timeSlots;
        ROOMS = rooms;
        COURSES = courses;
        random = new Random(System.currentTimeMillis());

        initSchedule();
        generateGeneRandomValues();
    }

    public int getGenomeValue() {
        int value = 10;
        int[][] schedule = new int[ROOMS][TIME_SLOTS];
        boolean hasConflicts = false;
        for (int i = 0; i < COURSES; i++) {
            int room = courses[i].room;
            int time = courses[i].time;
            if (schedule[room][time] == 1) {
                hasConflicts = true;
                System.out.println("conflict");
                return 0;
            } else {
                schedule[room][time] = 1;
            }
        }

        int gaps = getGaps(schedule);

        return value-gaps;
    }

    private boolean hasConflict(int[][] schedule) {

        return false;
    }

    private int getGaps(int[][] schedule) {
        int gaps = 0;
        for (int i = 0; i < ROOMS; i++) {
            int minIdx = getFirstCourseTime(schedule[i]);
            int maxIdx = getLastCourseTime(schedule[i]);
            for (int j =minIdx; j<maxIdx;j++) {
                if (schedule[i][j] != 1) {
                    gaps++;
                }
            }
        }
        return gaps;
    }

    private int getLastCourseTime(int[] roomCourses) {
        int i = TIME_SLOTS;
        while (i > 0 && roomCourses[i] != 1) {
            i--;
        }
        return i;
    }

    private int getFirstCourseTime(int[] roomCourses) {
        int i = 0;
        while(i<TIME_SLOTS && roomCourses[i] != 1) {
            i++;
        }
        return i;
    }

    private void generateGeneRandomValues() {
        for (int i = 0; i < COURSES; i++) {
            int randomTime = random.nextInt(TIME_SLOTS);
            int randomRoom = random.nextInt(ROOMS);

            courses[i].room = randomRoom;
            courses[i].time = randomTime;
        }
    }

    private void initSchedule() {
        courses = new Course[COURSES];
    }

    public Course[] getCourses() {
        return courses;
    }
}
