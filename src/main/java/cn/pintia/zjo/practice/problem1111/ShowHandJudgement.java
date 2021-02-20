package cn.pintia.zjo.practice.problem1111;


/**
 * @author Administrator
 */

public enum ShowHandJudgement implements IHandType {

    STRAIGHT_FLUSH(HandType.STRAIGHT_FLUSH) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.straightFlush(blackHand, whiteHand);
        }
    },

    FOUR_Of_A_KIND(HandType.FOUR_Of_A_KIND) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.fourOfAKind(blackHand, whiteHand);
        }
    },

    FULL_HOUSE(HandType.FULL_HOUSE) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.fullHouse(blackHand, whiteHand);
        }
    },

    FLUSH(HandType.FLUSH) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.flush(blackHand, whiteHand);
        }
    },

    STRAIGHT(HandType.STRAIGHT) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.straight(blackHand, whiteHand);
        }
    },

    THREE_OF_A_KIND(HandType.THREE_OF_A_KIND) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.threeOfKind(blackHand, whiteHand);
        }
    },

    TWO_PAIRS(HandType.TWO_PAIRS) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.twoPair(blackHand, whiteHand);
        }
    },

    PAIR(HandType.PAIR) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.pair(blackHand, whiteHand);
        }
    },

    HIGH_CARD(HandType.HIGH_CARD) {
        @Override
        public Judgement judgement(Card[] blackHand, Card[] whiteHand) {
            return ShowHandEvaluator.highCard(blackHand, whiteHand);
        }
    };

    private HandType handType;

    @Override
    public HandType getHandType() {
        return handType;
    }

    ShowHandJudgement(HandType handType) {
        this.handType = handType;
    }

    public abstract Judgement judgement(Card[] blackHand, Card[] whiteHand);


}
