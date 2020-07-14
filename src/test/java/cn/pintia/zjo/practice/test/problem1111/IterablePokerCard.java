package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;
import java.util.Iterator;

public class IterablePokerCard extends PokerCardGenerate implements Iterable<Card>{
    private int n;

    public IterablePokerCard(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Card> iterator() {
        return new Iterator<Card>() {

            @Override
            public boolean hasNext() {
                return (n > 0);
            }

            @Override
            public Card next() {
                n--;
                Card[] cards = IterablePokerCard.this.createTable();
                return cards[n];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (Card card : new IterablePokerCard(10)) {
            System.out.println(card.toString());
        }
    }
}
