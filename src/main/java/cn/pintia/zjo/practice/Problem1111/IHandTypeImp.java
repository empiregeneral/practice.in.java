package cn.pintia.zjo.practice.Problem1111;

import java.io.ByteArrayInputStream;
import java.util.*;

public class IHandTypeImp implements IHandType{
    private final int numOfCards = 5;
    private Card[] cards;

    public IHandTypeImp(String playerhands) {
        cards = toCards(playerhands);
    }

    public IHandTypeImp(Card[] cards) {
        Arrays.sort(cards);
        this.cards = cards;
    }

    private Card[] toCards(String playerhands) {
        List<Card> cardList = new ArrayList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(playerhands.getBytes()));
        while(scanner.hasNext()) {
            cardList.add(Card.valueOf(scanner.next()));
        }
        Collections.sort(cardList);
        return cardList.toArray(new Card[numOfCards]);
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
