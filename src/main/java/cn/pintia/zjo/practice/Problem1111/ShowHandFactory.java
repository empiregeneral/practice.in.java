package cn.pintia.zjo.practice.problem1111;

public class ShowHandFactory {
    public static Judgement showHandJudgement(Card[] blackHand, Card[] whiteHand, HandType handType) {
        Judgement result = null;
        switch (handType) {
            case STRAIGHT_FLUSH:
                result = ShowHandJudgement.STRAIGHT_FLUSH.judgement(blackHand, whiteHand);
                break;
            case FOUR_Of_A_KIND:
                result = ShowHandJudgement.FOUR_Of_A_KIND.judgement(blackHand, whiteHand);
                break;
            case FULL_HOUSE:
                result = ShowHandJudgement.FULL_HOUSE.judgement(blackHand, whiteHand);
                break;
            case FLUSH:
                result = ShowHandJudgement.FLUSH.judgement(blackHand, whiteHand);
                break;
            case STRAIGHT:
                result = ShowHandJudgement.STRAIGHT.judgement(blackHand, whiteHand);
                break;
            case THREE_OF_A_KIND:
                result = ShowHandJudgement.THREE_OF_A_KIND.judgement(blackHand, whiteHand);
                break;
            case TWO_PAIRS:
                result = ShowHandJudgement.TWO_PAIRS.judgement(blackHand, whiteHand);
                break;
            case PAIR:
                result = ShowHandJudgement.PAIR.judgement(blackHand, whiteHand);
                break;
            case HIGH_CARD:
                result = ShowHandJudgement.HIGH_CARD.judgement(blackHand, whiteHand);
                break;
        }

        return result;
    }
}
