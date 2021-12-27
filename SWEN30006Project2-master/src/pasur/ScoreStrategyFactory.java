package pasur;
import ch.aplu.jcardgame.Card;
import ch.aplu.jcardgame.Hand;

import java.util.ArrayList;

public class ScoreStrategyFactory {
    private static ScoreStrategyFactory instance;

    /**
     * Allows access to Singleton instance of factory
     * @return Singleton factory
     */
    public static ScoreStrategyFactory getInstance() {
        if (instance == null) {
            instance = new ScoreStrategyFactory();
        }
        return instance;
    }

    /**
     * Creates a composite strategy, adding to the composite all strategies that apply to the given player,
     * depending upon what is in their sur and picked cards piles
     * @param pickedCards Current picked cards pile
     * @param surs Current sur pile
     * @return Composite strategy that is relevand to the player
     */
    public IScoreStrategy getCompositeScoreStrategy(Hand pickedCards, Hand surs) {
        ArrayList<Card> cardList = pickedCards.getCardList();
        /** Merging hand and sur pile, as scoring cards can come from either **/
        if (!surs.isEmpty()) {
            for (int i = 0; i < surs.getCardList().size(); i++) {
                if (!cardList.contains(surs.get(i))) {
                    cardList.add(surs.get(i));
                }
            }
        }
        CompositeScoreStrategy compositeScoreStrategy = new CompositeScoreStrategy1();

        /* If player has 10 of diamonds */
        if (hasCard(Rank.TEN, Suit.DIAMONDS, cardList)) {
            compositeScoreStrategy.add(new TenDiamondsStrategy());
        }

        /* If player has 2 of clubs */
        if (hasCard(Rank.TWO, Suit.CLUBS, cardList)) {
            compositeScoreStrategy.add(new TwoClubsStrategy());
        }

        /* If player has over 7 diamonds */
        if (countCardsOfSuit(Suit.CLUBS, cardList) >= 7) {
            compositeScoreStrategy.add(new MostClubsScoreStrategy());
        }

        int numAces = countCardsOfRank(Rank.ACE, cardList);
        int numJacks = countCardsOfRank(Rank.JACK, cardList);

        /* Note that if the following do not apply to player, they will add a strategy that will have a score of 0 */
        compositeScoreStrategy.add(new NumOfCertainRankStrategy(numAces));
        compositeScoreStrategy.add(new NumOfCertainRankStrategy(numJacks));
        compositeScoreStrategy.add(new SurScoreStrategy(surs));

        return compositeScoreStrategy;

    }

    /**
     * Finds if a card of a given rank and suit is in a list of cards
     * @param rank Rank of target card
     * @param suit Suit of target card
     * @param cardList List of cards to search through
     * @return True if card is found in list, false otherwise
     */
    private boolean hasCard(Rank rank, Suit suit, ArrayList<Card> cardList) {
        for (int i=0; i<cardList.size(); i++) {
            if (cardList.get(i).getRank() == rank && cardList.get(i).getSuit() == suit) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts how many cards of a given rank are in a list of cards
     * @param rank Target rank
     * @param cardList List of cards to search through
     * @return Int corresponding to how many cards of given rank are in the list
     */
    private int countCardsOfRank(Rank rank, ArrayList<Card> cardList) {
        int counter = 0;
        for (int i=0; i<cardList.size(); i++) {
            if (cardList.get(i).getRank() == rank) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Counts how many cards of a given suit are in a list of cards
     * @param suit Target suit
     * @param cardList List of cards to search through
     * @return Int corresponding to how many cards of given suit are in the list
     */
    private int countCardsOfSuit(Suit suit, ArrayList<Card> cardList) {
        int counter = 0;
        for (int i=0; i<cardList.size(); i++) {
            if (cardList.get(i).getSuit() == suit) {
                counter++;
            }
        }
        return counter;
    }

}
