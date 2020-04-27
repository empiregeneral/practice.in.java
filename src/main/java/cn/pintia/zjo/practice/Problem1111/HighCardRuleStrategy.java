package cn.pintia.zjo.practice.problem1111;

import java.util.List;

public class HighCardRuleStrategy implements JudgeRuleStrategy {
    private HandType type = HandType.HIGH_CARD;
    private Card[] blackCards;
    private Card[] whiteCards;
    private HandType blackType;
    private HandType whiteType;

    public HighCardRuleStrategy(Card[] blackCards, Card[] whiteCards) {
        this.blackCards = blackCards;
        this.whiteCards = whiteCards;
        blackType = new IHandTypeImp(blackCards).getHandType();
        whiteType = new IHandTypeImp(whiteCards).getHandType();
    }

    @Override
    public void judge(HandType type) {
        for (int i = 0, j =0; i < blackCards.length && j < whiteCards.length; i++, j++) {
            if (blackCards[i].compareTo(whiteCards[j]) == 0 ) {

            }
        }

    }
}
