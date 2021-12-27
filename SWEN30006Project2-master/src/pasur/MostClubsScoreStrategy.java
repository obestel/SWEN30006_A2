package pasur;

public class MostClubsScoreStrategy implements IScoreStrategy {

    private final int SCORE = 7;

    /**
     * Gets score for most clubs strategy
     * @return Constant score
     */
    @Override
    public int getScore() {
        return SCORE;
    }
}
