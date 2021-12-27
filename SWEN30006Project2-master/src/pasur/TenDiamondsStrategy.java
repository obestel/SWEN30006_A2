package pasur;

public class TenDiamondsStrategy implements IScoreStrategy {

    public final int SCORE = 3;

    /**
     * Adds constant score if 10 of diamonds is in cards list
     * @return Score
     */
    @Override
    public int getScore() {
        return SCORE;
    }
}
