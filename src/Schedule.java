/**
 * Created by Piotr on 07.12.13.
 */
public class Schedule {

    private final int TIME_SLOTS;
    private final int ROOMS;
    private final int COURSES;
    private int[] genome;

    public Schedule(int timeSlots, int rooms, int courses) {
        TIME_SLOTS = timeSlots;
        ROOMS = rooms;
        COURSES = courses;

        initSchedule(TIME_SLOTS*ROOMS*COURSES);
    }

    private void initSchedule(int genomeSize) {
        genome = new int[genomeSize];
    }

    public int[] getGenome() {
        return genome;
    }

    public void setGenome(int[] genome) {
        this.genome = genome;
    }
}
