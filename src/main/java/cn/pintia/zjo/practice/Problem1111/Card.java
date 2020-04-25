package cn.pintia.zjo.practice.Problem1111;

import java.io.ByteArrayInputStream;
import java.util.*;

public class Card implements Comparable<Card> {

    /** Value of the card's face */
    protected Rank rank;
    /** Suit of the card */
    protected Suit suit;

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

        public static Rank getRank(char token) {
            for (Rank rank : values()) {
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

    public static void main(String[] args) {
        String hands = "AH 3D 5S KC KD";
        Scanner input = new Scanner(new ByteArrayInputStream(hands.getBytes()));
        List<Card> cards = new LinkedList<>();
        while(input.hasNext()) {
            cards.add(Card.valueOf(input.next()));
        }
        Collections.sort(cards);
        System.out.println(cards.toString());
    }
}
