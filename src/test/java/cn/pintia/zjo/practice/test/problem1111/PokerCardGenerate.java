package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;
import org.junit.Before;

import java.util.*;

public class PokerCardGenerate implements Generate<Card>{
    private List<Card> cardList;
    private final int capacity = 52;
    private Boolean shuffle;

    public PokerCardGenerate() {
        this(true);
    }

    public PokerCardGenerate(Boolean shuffle) {
        this.shuffle = shuffle;
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
        Card[] cards = cardList.toArray(new Card[capacity]);
        if (shuffle) {
            Shuffle.randomize(cards, capacity);
        }
        return cards;
    }
}
