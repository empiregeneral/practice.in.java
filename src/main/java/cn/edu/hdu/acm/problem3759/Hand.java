package cn.edu.hdu.acm.problem3759;

public class Hand {
    static final int HAND_SIZE = 5;
    static final int C1 = HAND_SIZE - 1;
    static final int C2 = HAND_SIZE - 2;
    static final int C3 = HAND_SIZE - 3;
    static final int C4 = HAND_SIZE - 4;
    static final int C5 = HAND_SIZE - 5;

    static final String R = "23456789TJQKA";
    static final String S = "CDHS";

    static final int ACE = R.indexOf('A');
    static final int TWO = R.indexOf('2');
    static final int THREE = R.indexOf('3');
    static final int FOUR = R.indexOf('4');
    static final int FIVE = R.indexOf('5');

    static final int CARD_BITS = 4;
    static final int CARD_MASK = (1 << CARD_BITS) - 1;
    static final int FLUSH_SHIFT = HAND_SIZE * CARD_BITS;
    static final int FLUSH_MASK = 1 << FLUSH_SHIFT;

    static int getCard(int hand, int i) {
        assert i >= 0 && i < HAND_SIZE;
        return (hand >> (CARD_BITS * i)) & CARD_MASK;
    }

    static int setCard(int hand, int i, int rank) {
        assert i >= 0 && i < HAND_SIZE;
        int shift = CARD_BITS * i;
        return (hand & ~(CARD_MASK << shift)) | (rank << shift);
    }

    static int swapCard(int hand, int i, int j) {
        return setCard(setCard(hand, i, getCard(hand, j)), j, getCard(hand, i));
    }

    static int moveCard(int hand, int to, int from) {
        assert to >= from;
        for (int i = from; i < to; i++) {
            hand = swapCard(hand, i, i + 1);
        }
        return hand;
    }

    static boolean isFlush(int hand) {
        return (hand >> FLUSH_SHIFT) != 0;
    }

    static int setFlush(int hand) {
        return hand | FLUSH_MASK;
    }

    private static int clearFlush(int hand) {
        return hand & ~FLUSH_MASK;
    }

    static final int ACE_ROLLED_STRAIGHT =
            setCard(setCard(setCard(setCard(setCard(0,
                    C1, ACE),
                    C2, FIVE),
                    C3, FOUR),
                    C4, THREE),
                    C5, TWO);

    enum Ranking {
        HIGH_CARD {
            @Override
            int map(int hand) {
                return hand;
            }
            },
        ONE_PAIR {
            @Override
            int map(int hand) {
                for (int i = HAND_SIZE; --i > 0;) {
                    if (getCard(hand, i) == getCard(hand, i - 1)) {
                        return moveCard(moveCard(hand, C1, i), C2, i - 1);
                    }
                }
                return -1;
            }},
        TWO_PAIRS {
            @Override
            int map(int hand) {
                hand = ONE_PAIR.map(hand);
                if (hand < 0) {
                    return -1;
                }
                for (int i = HAND_SIZE - 2; --i > 0;) {
                    if (getCard(hand, i) == getCard(hand, i - 1)) {
                        return moveCard(moveCard(hand, C3, i), C4, i - 1);
                    }
                }
                return -1;
            }},
        THREE_OF_A_KIND {
            @Override
            int map(int hand) {
                for (int i = HAND_SIZE; --i > 1;)
                {
                    if (getCard(hand, i) == getCard(hand, i - 1) && getCard(hand, i) == getCard(hand, i - 2))
                    {
                        return moveCard(moveCard(moveCard(hand, C1, i), C2, i - 1), C3, i - 2);
                    }
                }
                return -1;
            }},
        STRAIGHT {
            @Override
            int map(int hand) {
                if (hand == ACE_ROLLED_STRAIGHT)
                {
                    return moveCard(hand, C1, C2);
                }
                for (int i = HAND_SIZE; --i > 0;)
                {
                    if (getCard(hand, i) != getCard(hand, i - 1) + 1)
                    {
                        return -1;
                    }
                }
                return hand;
            }},
        FLUSH {
            @Override
            int map(int hand) {
                return isFlush(hand) ? hand : -1;
            }},
        FULL_HOUSE {
            @Override
            int map(int hand) {
                hand = THREE_OF_A_KIND.map(hand);
                return hand < 0 ? -1 : getCard(hand, C4) == getCard(hand, C5) ? hand : -1;
            }},
        FOUR_OR_A_KIND {
            @Override
            int map(int hand) {
                for (int i = HAND_SIZE; --i > 2;) {
                    if (getCard(hand, i) == getCard(hand, i - 1) && getCard(hand, i) == getCard(hand, i - 2) && getCard(hand, i) == getCard(hand, i - 3)) {
                        return moveCard(moveCard(moveCard(moveCard(hand, C1, i), C2, i - 1), C3, i - 2), C4, i - 3);
                    }
                }
                return -1;
            }},
        STRAIGHT_FLUSH {
            @Override
            int map(int hand) {
                return isFlush(hand) ? STRAIGHT.map(clearFlush(hand)) : -1;
            }};

        abstract int map(int hand);
    }

    static final Ranking[] RANKINGS = Ranking.values();

    static class HandScore implements Comparable<HandScore> {
        final int hand;
        final int map;
        final Ranking ranking;

        public HandScore(int hand) {
            this.hand = hand;
            for (int i = RANKINGS.length; --i > 0;) {
                Ranking ranking = RANKINGS[i];
                int map = ranking.map(hand);
                if (map >= 0) {
                    this.map = map;
                    this.ranking = ranking;
                    return;
                }
            }
            throw new AssertionError("This cannot happen");
        }

        @Override
        public int compareTo(HandScore o) {
            int i = ranking.compareTo(o.ranking);
            if (i != 0) {
                return i;
            }
            return map - o.map;
        }
    }

}
