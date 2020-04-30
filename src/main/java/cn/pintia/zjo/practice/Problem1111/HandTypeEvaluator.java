package cn.pintia.zjo.practice.Problem1111;

/**
 * It's a Utility class to verifies all the hand types.
 */
public class HandTypeEvaluator {
    /**
     * Verifies if a given hand of any size contanis a Straight Flush. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
    public static boolean hasStraightFlush(Card[] hand) {
        return hasStraight(hand) && hasFlush(hand);
    }

    /**
     * Verifies if a given hand of any size contains a Four of a Kind. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains a Full House. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains a Flush.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains a Straight. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains a Three of a Kind. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains Two Pairs. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains a Pair. <br>
     * Assertive: hand must be sorted.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
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

    /**
     * Verifies if a given hand of any size contains a Highest Card.
     *
     * @param hand Hand.
     * @return {@code true} if contains, {@code false} otherwise.
     */
    public static boolean hasHighestCard(Card[] hand) {
        return true;
    }

}
