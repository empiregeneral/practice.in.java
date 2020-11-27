package cn.edu.hdu.acm.problem1629;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum HandType implements IHandType {

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
