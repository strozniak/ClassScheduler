/**
 * Created by Piotr on 7.12.13.
 */
public class App {

    public static final int SCHEDULE_NUMBER = 100;

    public static void main(String[] args) {

        Population schedulePopulation = new SchedulePopulation(SCHEDULE_NUMBER);
        schedulePopulation.generatePopulation();

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        geneticAlgorithm.setPopulation(schedulePopulation);

        StopCondition populationCount = new PopulationCount();
        geneticAlgorithm.setStopCondition(populationCount);

        // generates/evaluetes... new population till stop condition
        geneticAlgorithm.populate();

        Schdeule bestSchedule = geneticAlgorithm.getBestSchedule();

        print(bestSchedule);

    }
}
