/**
 * Created by Piotr on 07.12.13.
 */
public class PopulationCount implements StopCondition {
    private int counter = 20;
    @Override
    public boolean isStopConditionFullfilled() {
        return counter-- <= 0;
    }
}
