import Model.Population;
import Model.Schedule;

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

        while (populationCount.isStopConditionFullfilled()) {

        }
    }

    public Schedule getBestSchedule() {
        return null;
    }
}
