package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;

import java.util.*;

public class PokerCardGenerate implements Generate<Card> {
    private List<Card> cardList;
    private final int capacity = 52;

    public PokerCardGenerate() {
        cardList = new LinkedList<>();
        for (Card.Suit suit : Card.Suit.values()){
            for (Card.Rank rank : Card.Rank.values()) {
                cardList.add(new Card(rank, suit));
            }
        }
    }

    @Override
    public Card next() {
        return cardList.get(new Random().nextInt(capacity));
    }

    @Override
    public Card[] createTable() {
        return cardList.toArray(new Card[capacity]);
    }

    public static void main(String[] args) {
        Generate<Card> generate = new PokerCardGenerate();
        Card[] cards = generate.createTable();
        Shuffle.randomize(cards, cards.length);
        Card[] cardsInDeck = Arrays.copyOf(cards, 10);
        System.out.println(Arrays.toString(cardsInDeck));
    }
}
