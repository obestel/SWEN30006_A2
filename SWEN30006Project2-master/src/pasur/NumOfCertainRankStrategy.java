package pasur;

public class NumOfCertainRankStrategy implements IScoreStrategy {

    private int numRank;

    public NumOfCertainRankStrategy(int numRank) {
        this.numRank = numRank;
    }

    /**
     * Gets score for number of a certain rank strategy
     * Score is just how many of a given rank their are in list of cards
     * @return Score
     */
    @Override
    public int getScore() {
        return numRank;
    }
}
