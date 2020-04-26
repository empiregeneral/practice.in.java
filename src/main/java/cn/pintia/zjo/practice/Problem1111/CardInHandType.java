package cn.pintia.zjo.practice.problem1111;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardInHandType {
    private final int numOfCards = 5;
    private Card[] cards;

    public CardInHandType(String playerhands) {
        cards = toCards(playerhands);
    }

    public void printHandType() {
        for (HandType handType : HandType.values()) {
            if (handType.isValid(cards)) {
                System.out.println(handType.getDescription());
            }
        }
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

    public static void main(String[] args) {
        CardInHandType cardInHandType = new CardInHandType("2C AD AS AC AH");
        cardInHandType.printHandType();
    }
}
