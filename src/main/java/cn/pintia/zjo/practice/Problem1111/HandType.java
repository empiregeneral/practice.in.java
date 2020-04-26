package cn.pintia.zjo.practice.problem1111;


public enum HandType {
    /**
     * 同花顺，按照最大的牌面大小排序。
     */
    STRAIGHT_FLUSH("STRAIGHT_FLUSH: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasStraightFlush(hand);
        }
    },
    /**
     * 四条,4个同样的牌加一个牌，按照4张牌面大小排序。
     */
    FOUR_Of_A_KIND("4 cards with the same value. Ranked by the value of the 4 cards.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFourOfAKind(hand);
        }
    },
    /**
     * 葫芦，3个同样的牌加上1个对子，按照3张相同的牌面大小排序。
     */
    FULL_HOUSE("FULL_HOUSE: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFullHouse(hand);
        }
    },
    /**
     * 同花，5个花色一样的牌, 按照最大牌面大小排序。
     */
    FLUSH("Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFlush(hand);
        }
    },
    /**
     * 顺子,五张依次递增的牌,按照最大牌的大小排序
     */
    STRAIGHT("Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasStraight(hand);
        }
    },
    /**
     * 三条，3个同样牌，按照3张牌的牌面大小排序
     */
    THREE_OF_A_KIND("THREE_OF_A_KIND: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasFourOfAKind(hand);
        }
    },
    /**
     * 2个对子,按照最大的一对对子的大小进行排序，如果相同，比较较小的一对对子，如果还是相同，请比较剩下的牌面
     */
    TWO_PAIRS("TWO PAIRS: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasTwoPairs(hand);
        }
    },
    /**
     * 1个对子
     */
    PAIR("2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasOnePair(hand);
        }
    },
    /**
     * 牌面最大的牌
     */
    HIGH_CARD("Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are ranked by the next highest, and so on.") {
        @Override
        protected boolean isValid(Card[] hand) {
            return HandTypeEvaluator.hasHighestCard(hand);
        }
    };


    private String description;

    HandType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Verify if a handType is present in a given hand.
     *
     * @param hand Set of cards.
     * @return {@code true} if the hand type is present in the hand, {@code false}
     *         otherwise.
     */
    protected abstract boolean isValid(Card[] hand);

    public static void main(String[] args) {
        for (HandType handType : HandType.values()) {
            System.out.println(handType + ": " + handType.getDescription());
        }
    }
}
