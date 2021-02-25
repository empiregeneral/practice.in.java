package cn.pintia.zjo.practice.problem1111;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum HandType implements IHandType {

    /**
     * 牌面最大的牌
     */
    HIGH_CARD("HIGH_CARD", 0) {
        @Override
        public HandType getHandType() {
            return HandType.HIGH_CARD;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasHighestCard(hand);
        }
    },

    /**
     * 对子
     */
    PAIR("PAIR",1) {
        @Override
        public HandType getHandType() {
            return HandType.PAIR;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasOnePair(hand);
        }
    },

    /**
     * 2个对子,按照最大的一对对子的大小进行排序，如果相同，比较较小的一对对子，如果还是相同，请比较剩下的牌面
     */
    TWO_PAIRS("TWO PAIRS", 2) {
        @Override
        public HandType getHandType() {
            return HandType.TWO_PAIRS;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasTwoPairs(hand);
        }
    },

    /**
     * 三条，3个同样牌，按照3张牌的牌面大小排序
     */
    THREE_OF_A_KIND("THREE_OF_A_KIND", 3) {
        @Override
        public HandType getHandType() {
            return HandType.THREE_OF_A_KIND;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasThreeOfAKind(hand);
        }
    },

    /**
     * 顺子,五张依次递增的牌,按照最大牌的大小排序
     */
    STRAIGHT("STRAIGHT", 4) {
        @Override
        public HandType getHandType() {
            return HandType.STRAIGHT;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasStraight(hand);
        }
    },

    /**
     * 同花，5个花色一样的牌, 按照最大牌面大小排序。
     */
    FLUSH("FLUSH", 5) {
        @Override
        public HandType getHandType() {
            return HandType.FLUSH;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFlush(hand);
        }
    },

    /**
     * 葫芦，3个同样的牌加上1个对子，按照3张相同的牌面大小排序。
     */
    FULL_HOUSE("FULL_HOUSE", 6) {
        @Override
        public HandType getHandType() {
            return HandType.FULL_HOUSE;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFullHouse(hand);
        }
    },

    /**
     * 四条,4个同样的牌加一个牌，按照4张牌面大小排序。
     */
    FOUR_Of_A_KIND("FOUR_OF_A_KINE", 7) {
        @Override
        public HandType getHandType() {
            return HandType.FOUR_Of_A_KIND;
        }

        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFourOfAKind(hand);
        }
    },
    /**
     * 同花顺，按照最大的牌面大小排序。
     */
    STRAIGHT_FLUSH("STRAIGHT_FLUSH", 8) {
        @Override
        public HandType getHandType() {
            return HandType.STRAIGHT_FLUSH;
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

        System.out.println(HandType.fromString("HIGH_CARD").get());
    }

}
