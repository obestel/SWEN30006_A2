package pasur;

public class TwoClubsStrategy implements IScoreStrategy {

    public final int SCORE = 2;

    /**
     * Adds constant score if 2 of clubs is in cards list
     * @return Score
     */
    @Override
    public int getScore() {
        return SCORE;
    }
}
