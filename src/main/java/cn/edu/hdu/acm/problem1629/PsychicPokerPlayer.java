package cn.edu.hdu.acm.problem1629;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;

public class PsychicPokerPlayer implements Readable{
    private int count = 1;
    private HandType bestHandType = HandType.high_card;
    private List<Card> handCards;
    private List<Card> deckCards;

    public PsychicPokerPlayer(List<Card> handCards, List<Card> deckCards) {
        this.handCards = handCards;
        this.deckCards = deckCards;

    }

    private void checkBestHandType(Card[] currentCards) {
        Arrays.sort(currentCards);
        if (HandTypeEvaluator.hasStraightFlush(currentCards)) {
            if (bestHandType.getScores() > HandType.straight_flush.getScores()) {
                bestHandType = HandType.straight_flush;
            }
        } else if (HandTypeEvaluator.hasFourOfAKind(currentCards)) {
            if (bestHandType.getScores() > HandType.four_of_a_kind.getScores()) {
                bestHandType = HandType.four_of_a_kind;
            }
        } else if (HandTypeEvaluator.hasFullHouse(currentCards)) {
            if (bestHandType.getScores() > HandType.full_house.getScores()) {
                bestHandType = HandType.full_house;
            }
        } else if (HandTypeEvaluator.hasStraight(currentCards)) {
            if (bestHandType.getScores() > HandType.straight.getScores()) {
                bestHandType = HandType.straight;
            }
        } else if (HandTypeEvaluator.hasFlush(currentCards)) {
            if (bestHandType.getScores() > HandType.flush.getScores()) {
                bestHandType = HandType.flush;
            }
        } else if (HandTypeEvaluator.hasThreeOfAKind(currentCards)) {
            if (bestHandType.getScores() > HandType.three_of_a_kind.getScores()) {
                bestHandType = HandType.three_of_a_kind;
            }
        } else if (HandTypeEvaluator.hasTwoPairs(currentCards)) {
            if (bestHandType.getScores() > HandType.two_pair.getScores()) {
                bestHandType = HandType.two_pair;
            }
        } else if (HandTypeEvaluator.hasOnePair(currentCards)) {
            if (bestHandType.getScores() > HandType.pair.getScores()) {
                bestHandType = HandType.pair;
            }
        }


        return;
    }

    public HandType startPsychicEyes(List<Card> handCards, List<Card> deckCards) {
        // check score for the current hand
        checkBestHandType(handCards.toArray(new Card[handCards.size()]));

        // take one by one cards from the deck
        Card[] currentHand = new Card[5];
        for (int i = 0; i < 5; i++) {
            currentHand[i] = new Card(deckCards.get(i).rank, deckCards.get(i).suit);
            // use recursion to match cards from the deck and cards from the
            // hand
            matchWithHandCards(currentHand, handCards, i + 1, 0);
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
    private void matchWithHandCards(Card[] currentHand, List<Card> handCards,
                                    int currentIdx, int startIdx) {
        // there are already 5 cards to check
        if (currentIdx == 5) {
            checkBestHandType(currentHand);
            for (Card card : currentHand) {
                System.out.print(card.toString()+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = startIdx; i < 5; i++) {
            currentHand[currentIdx] = handCards.get(i);
            matchWithHandCards(currentHand, handCards, currentIdx + 1, i + 1);
        }
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        startPsychicEyes(this.handCards, this.deckCards);
//        startPsychicEyes(this.handCards, this.deckCards);
        cb.append("Hand: " + cardListInfo(handCards)  + "Deck: " + cardListInfo(deckCards) + "Best hand: " + bestHandType.getDescription());


        return 10;
    }

    private String cardListInfo(List<Card> cardList) {
        StringBuilder sb = new StringBuilder("");
        for (Card card : cardList) {
            sb.append(card.toString() + " ");
        }
        return sb.toString();
    }
}
