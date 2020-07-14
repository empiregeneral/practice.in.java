package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;
import java.util.Iterator;

public class DealingPorkCard extends PokerCardGenerate implements Iterable<Card>{
    private int n;

    public DealingPorkCard(int n) {
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
                Card[] cards = DealingPorkCard.this.createTable();
                return cards[n];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        int blackOrWhite = 0;
        StringBuilder blackHands = new StringBuilder("");
        StringBuilder whiteHands = new StringBuilder("");
        for (Card card : new DealingPorkCard(10)) {
            if (blackOrWhite % 2 == 0) {
                blackHands.append(card.toString() + " ");
            } else {
                whiteHands.append(card.toString() + " ");
            }
            blackOrWhite++;
        }
    }
}
