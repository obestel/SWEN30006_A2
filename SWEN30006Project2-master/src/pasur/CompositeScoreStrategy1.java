package pasur;

public class CompositeScoreStrategy1 extends CompositeScoreStrategy  {

    /**
     * Gets the total score, summing the score for all strategies
     * @return Total score
     */
    @Override
    public int getScore() {
        if (this.scoreStrategies.size() > 0) {
            int score = 0;
            for (int i = 0; i < this.scoreStrategies.size(); i++) {
                score += this.scoreStrategies.get(i).getScore();
            }

            return score;
        }
        else return 0;
    }
}
