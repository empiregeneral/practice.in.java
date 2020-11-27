package cn.edu.hdu.acm.problem1629;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gambler {
    private HandType bestHandType = HandType.high_card;

    /**
     * Finds the best hand from the provided sets of cards
     *
     * @param handCards
     *            list of 5 first cards
     * @param deckCards
     *            list of 5 last cards
     * @return
     */
    public HandType playCards(List<Card> handCards, List<Card> deckCards) {
        // check score for the current hand
        checkForBestHandType(handCards.toArray(new Card[handCards.size()]));

        // take one by one cards from the deck
        Card[] currentHand = new Card[5];
        for (int i = 0; i < 5; i++) {
            currentHand[i] = new Card(deckCards.get(i).rank, deckCards.get(i).suit);
            // use recursion to match cards from the deck and cards from the
            // hand
            matchWithHandCards(currentHand, handCards, i+1, 0);
        }

        return bestHandType;
    }

    /**
     * Fills in recursively the deck of cards for best hand verification
     *
     * @param currentHand
     *            array of cards for the best hand check
     * @param handCards
     *            list of the hand cards
     * @param currentIdx
     *            currently processed index
     * @param startIdx
     *            index from which to start processing
     */
    private void matchWithHandCards(Card[] currentHand, List<Card> handCards, int currentIdx, int startIdx) {
        // there are already 5 cards to check
        if (currentIdx == 5) {
            checkForBestHandType(currentHand);

            return;
        }

        for (int i = startIdx; i < 5; i++) {
            currentHand[currentIdx] = handCards.get(i);
            matchWithHandCards(currentHand, handCards, currentIdx + 1, i+1);
        }
    }


    /**
     * Verify if particular card set is the best hand
     *
     * @param currentCards
     */
    private void checkForBestHandType(Card[] currentCards) {
        List<Card> cardsToCheck = new ArrayList<>();
        for (Card card : currentCards) {
            cardsToCheck.add(card);
        }

        Collections.sort(cardsToCheck);

        Card[] cards = cardsToCheck.toArray(new Card[cardsToCheck.size()]);
        if (HandTypeEvaluator.hasStraightFlush(cards)) {
            if (bestHandType.getScores() < HandType.straight_flush.getScores()) {
                bestHandType = HandType.straight_flush;
            }
        } else if (HandTypeEvaluator.hasFourOfAKind(cards)) {
            if (bestHandType.getScores() < HandType.four_of_a_kind.getScores()) {
                bestHandType = HandType.four_of_a_kind;
            }
        } else if (HandTypeEvaluator.hasFullHouse(cards)) {
            if (bestHandType.getScores() < HandType.full_house.getScores()) {
                bestHandType = HandType.full_house;
            }
        } else if (HandTypeEvaluator.hasStraight(cards)) {
            if (bestHandType.getScores() < HandType.straight.getScores()) {
                bestHandType = HandType.straight;
            }
        } else if (HandTypeEvaluator.hasFlush(cards)) {
            if (bestHandType.getScores() < HandType.flush.getScores()) {
                bestHandType = HandType.flush;
            }
        } else if (HandTypeEvaluator.hasThreeOfAKind(cards)) {
            if (bestHandType.getScores() < HandType.three_of_a_kind.getScores()) {
                bestHandType = HandType.three_of_a_kind;
            }
        } else if (HandTypeEvaluator.hasTwoPairs(cards)) {
            if (bestHandType.getScores() < HandType.two_pair.getScores()) {
                bestHandType = HandType.two_pair;
            }
        } else if (HandTypeEvaluator.hasOnePair(cards)) {
            if (bestHandType.getScores() < HandType.pair.getScores()) {
                bestHandType = HandType.pair;
            }
        }

        return;
    }
}
