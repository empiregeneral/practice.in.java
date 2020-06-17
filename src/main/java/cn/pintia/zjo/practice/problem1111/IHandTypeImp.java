package cn.pintia.zjo.practice.problem1111;

import java.util.*;

public class IHandTypeImp implements IHandType{
    private Card[] cards;

    public IHandTypeImp(String playerhands) {
        cards = CardUtils.toCards(playerhands);
    }

    public IHandTypeImp(Card[] cards) {
        Arrays.sort(cards);
        this.cards = cards;
    }

    @Override
    public HandType getHandType() {
        int maxScores = 0;
        HandType type = HandType.HIGH_CARD;
        for (HandType handType : HandType.values()) {
            if (handType.isValid(cards)) {
                if (handType.getScores() > maxScores) {
                    maxScores = handType.getScores();
                    type = handType.getHandType();
                }
            }
        }
        return type;
    }
}
