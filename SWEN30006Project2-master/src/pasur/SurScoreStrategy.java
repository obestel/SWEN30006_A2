package pasur;

import ch.aplu.jcardgame.Hand;

public class SurScoreStrategy implements IScoreStrategy {
    private Hand surs;
    private final int SCORE_PER_SUR = 5;


    public SurScoreStrategy(Hand surs) {
        this.surs = surs;
    }

    /**
     * Adds score based on number of cards in sur pile, times a modifier
     * @return Score
     */
    @Override
    public int getScore() {
        if (surs.isEmpty()) {
            return 0;
        }
        return surs.getCardList().size() * SCORE_PER_SUR;
    }
}
