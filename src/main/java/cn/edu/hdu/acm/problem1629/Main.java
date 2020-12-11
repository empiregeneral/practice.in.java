package cn.edu.hdu.acm.problem1629;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.Collections;

import static java.util.stream.Collectors.toMap;

public class Main {
    private static final String SEPARATOR = " ";
    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            String[] cards = input.nextLine().split(SEPARATOR);
            List<Card> handCards = new ArrayList<>();
            List<Card> deckCards = new ArrayList<>();
            for (int i = 0; i < cards.length; i++) {
                if (i < 5) {
                    handCards.add(Card.valueOf(cards[i]));
                } else {
                    deckCards.add(Card.valueOf(cards[i]));
                }
            }

            Readable readable = new PsychicPokerPlayer(handCards, deckCards);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}

class PsychicPokerPlayer implements Readable{
    private int count = 1;
    private HandType bestHandType;
    private List<Card> handCards;
    private List<Card> deckCards;
    private Gambler gambler = new Gambler();

    public PsychicPokerPlayer(List<Card> handCards, List<Card> deckCards) {
        this.handCards = handCards;
        this.deckCards = deckCards;
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        bestHandType = gambler.playCards(this.handCards, this.deckCards);
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

interface IHandType {
    HandType getHandType();
}

enum HandType implements IHandType {

    high_card("highest-card", 0) {
        @Override
        public HandType getHandType() {
            return HandType.high_card;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasHighestCard(hand);
        }
    },

    pair("one-pair", 1) {
        @Override
        public HandType getHandType() {
            return HandType.pair;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasOnePair(hand);
        }
    },

    two_pair("two-pairs", 2) {
        @Override
        public HandType getHandType() {
            return HandType.two_pair;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasTwoPairs(hand);
        }
    },

    three_of_a_kind("three-of-a-kind", 3) {
        @Override
        public HandType getHandType() {
            return HandType.three_of_a_kind;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasThreeOfAKind(hand);
        }
    },

    straight("straight", 4) {
        @Override
        public HandType getHandType() {
            return HandType.straight;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasStraight(hand);
        }
    },

    flush("flush", 5) {
        @Override
        public HandType getHandType() {
            return HandType.flush;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFlush(hand);
        }
    },

    full_house("full-house", 6) {
        @Override
        public HandType getHandType() {
            return HandType.full_house;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFullHouse(hand);
        }
    },

    four_of_a_kind("four-of-a-kind", 7) {
        @Override
        public HandType getHandType() {
            return HandType.four_of_a_kind;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFourOfAKind(hand);
        }
    },

    straight_flush("straight-flush", 8) {
        @Override
        public HandType getHandType() {
            return HandType.straight_flush;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasStraightFlush(hand);
        }
    };

    private String description;
    private int scores;

    HandType(String description, int scores) {
        this.description = description;
        this.scores = scores;
    }

    public String getDescription() {
        return description;
    }

    public int getScores() {
        return scores;
    }

    /**
     * Verify if a handType is present in a given hand.
     *
     * @param hand Set of cards.
     * @return {@code true} if the hand type is present in the hand, {@code false}
     * otherwise.
     */
    protected abstract boolean isValid(Card[] hand);

    private static final Map<String, HandType> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, e -> e));

    public static Optional<HandType> fromString(String handType) {
        return Optional.ofNullable(stringToEnum.get(handType));
    }

    public static void main(String[] args) {
        System.out.println(HandType.fromString("straight_flush").get());
    }
}

class Card implements Comparable<Card> {

    /** Value of the card's face */
    protected Card.Rank rank;
    /** Suit of the card */
    protected Card.Suit suit;

    /**
     * Constructor.
     *
     * @param rank Rank.
     * @param suit Suit.
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.getToken() + suit.toString();
    }

    /**
     * Converts a valid symbol into a Card.
     *
     * @param txt
     * @return Valid card.
     */
    public static Card valueOf(String txt) {
        if (txt == null || txt.isEmpty()) {
            throw new IllegalArgumentException("Invalid Token: " + txt);
        }

        txt = txt.trim().toUpperCase();

        if (txt.length() != 2) {
            throw new IllegalArgumentException("Invalid Token: " + txt);
        }

        Rank rank = Rank.getRank(txt.charAt(0));
        Suit suit = Suit.valueOf("" + txt.charAt(1));
        return new Card(rank, suit);
    }


    /**
     * Suits list.
     */
    public enum Suit {
        /** Clubs */
        C,
        /** Hearts */
        H,
        /** Spades */
        S,
        /** Diamonds */
        D
    };

    /**
     * Ranks list.
     */
    public enum Rank {
        /**
         * Two
         */
        TWO('2'),
        /**
         * Three
         */
        THREE('3'),
        /**
         * Four
         */
        FOUR('4'),
        /**
         * Five
         */
        FIVE('5'),
        /**
         * Six
         */
        SIX('6'),
        /**
         * Seven
         */
        SEVEN('7'),
        /**
         * Eight
         */
        EIGHT('8'),
        /**
         * Nine
         */
        NINE('9'),
        /**
         * Ten
         */
        TEN('T'),
        /**
         * Jack
         */
        JACK('J'),
        /**
         * Queen
         */
        QUEEN('Q'),
        /**
         * King
         */
        KING('K'),
        /**
         * Ace
         */
        ACE('A');

        /**
         * Rank's symbol
         */
        final private char token;

        /**
         * @param token
         */
        Rank(char token) {
            this.token = token;
        }

        /**
         * @return Rank's Symbol.
         */
        public char getToken() {
            return token;
        }

        public static Card.Rank getRank(char token) {
            for (Card.Rank rank : values()) {
                if (token == rank.getToken()) {
                    return rank;
                }
            }
            throw new IllegalArgumentException("Invalid Token: " + token);
        }
    }

    @Override
    public int compareTo(Card card) {
        return this.getRank().compareTo(card.getRank());
    }
}

class Gambler {
    private HandType bestHandType = HandType.high_card;

    public HandType playCards(List<Card> handCards, List<Card> deckCards) {
        checkForBestHandType(handCards.toArray(new Card[handCards.size()]));

        Card[] currentHand = new Card[5];

        for (int i = 0; i < 5; i++) {
            currentHand[i] = new Card(deckCards.get(i).rank, deckCards.get(i).suit);
            matchWithHandCards(currentHand, handCards, i+1, 0);
        }

        return bestHandType;
    }

    private void matchWithHandCards(Card[] currentHand, List<Card> handCards, int currentIdx, int startIdx) {
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

class HandTypeEvaluator {
    public static boolean hasHighestCard(Card[] hand) {
        return true;
    }

    public static boolean hasOnePair(Card[] hand) {
        if (hand.length >= 2) {
            for (int i = 0; i < hand.length - 1; i++) {
                if (hand[i].getRank() == hand[i + 1].getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasTwoPairs(Card[] hand) {
        if (hand.length >= 4) {
            int indx = -1;
            for (int i = 0; i < hand.length - 1; i++) {
                if (hand[i].getRank() == hand[i + 1].getRank()) {
                    indx = i;
                    break;
                }
            }
            for (int i = indx + 2; i < hand.length - 1; i++) {
                if (hand[i].getRank() == hand[i + 1].getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasThreeOfAKind(Card[] hand) {
        if (hand.length >= 3) {
            for (int i = 0; i < hand.length - 2; i++) {
                if (hand[i].getRank() == hand[i + 1].getRank()
                        && hand[i + 1].getRank() == hand[i + 2].getRank()
                        && hand[i].getRank() == hand[i+2].getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasStraight(Card[] hand) {
        if (hand.length >= 5) {
            int seqCards = 1;
            int length = hand.length - 1;
            if (hand[length].getRank() == Card.Rank.ACE
                    && hand[length - 4].getRank() == Card.Rank.TWO) {
                length--;
                seqCards++;
            }
            for (int i = 0; i < length; i++) {
                if (hand[i + 1].getRank().ordinal() - hand[i].getRank().ordinal() == 1) {
                    seqCards++;
                    if (seqCards == 5) {
                        return true;
                    }
                }
                else {
                    seqCards = 1;
                }
            }
        }
        return false;
    }

    public static boolean hasFlush(Card[] hand) {
        if (hand.length >= 5) {
            int c = 0, h = 0, s = 0, d = 0;
            for (int i = 0; i < hand.length; i++) {
                if (hand[i].getSuit() == Card.Suit.C) {
                    c++;
                }
                else if (hand[i].getSuit() == Card.Suit.H) {
                    h++;
                }
                else if (hand[i].getSuit() == Card.Suit.S) {
                    s++;
                }
                else {
                    d++;
                }
                if (c == 5 || h == 5 || s == 5 || d == 5) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean hasFullHouse(Card[] hand) {
        if (hand.length >= 5) {
            Card.Rank tValue = null, pValue = null;
            for (int i = 0; i < hand.length - 2; i++) {
                if (hand[i].getRank() == hand[i + 1].getRank()
                        && hand[i + 1].getRank() == hand[i + 2].getRank()) {
                    tValue = hand[i].getRank();
                    break;
                }
            }
            for (int i = 0; i < hand.length - 1; i++) {
                if (hand[i].getRank() == hand[i + 1].getRank()
                        && hand[i].getRank() != tValue) {
                    pValue = hand[i].getRank();
                    break;
                }
            }
            if (tValue != null && pValue != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasFourOfAKind(Card[] hand) {
        if (hand.length >= 4) {
            for (int i = 0; i <= hand.length - 4; i++) {
                if ((hand[i].compareTo(hand[i + 1]) == 0)
                        && (hand[i + 1].compareTo(hand[i + 2]) == 0)
                        && (hand[i + 2].compareTo(hand[i + 3]) == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasStraightFlush(Card[] hand) {
        return hasStraight(hand) && hasFlush(hand);
    }
}
