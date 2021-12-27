package pasur;

import java.util.ArrayList;

public abstract class CompositeScoreStrategy implements IScoreStrategy {
    protected ArrayList<IScoreStrategy> scoreStrategies = new ArrayList<IScoreStrategy>();

    /**
     * Adds strategy to strategy list
     * @param strategy Strategy to be included in composite strategy
     */
    public void add(IScoreStrategy strategy) {
        scoreStrategies.add(strategy);
    }

    /**
     * Gets the total score, summing the score for all strategies
     * @return Total score
     */
    public abstract int getScore();
}
