package cn.pintia.zjo.practice.test.problem1111;

import cn.hutool.core.io.file.FileAppender;
import cn.pintia.zjo.practice.problem1111.Card;
import cn.pintia.zjo.practice.problem1111.ShowHandInDeck;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

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
        final int playTimes = 10;
        for (int i = 0; i < playTimes; i++) {
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
            Readable readable = new ShowHandInDeck(blackHands.toString().trim(), whiteHands.toString().trim());
            FileAppender fileAppender = new FileAppender(new File("src/test/resources/data_zjo_1111.csv"), 10, true);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                fileAppender.append(blackHands.toString().trim() + " " + whiteHands.toString().trim() + "," + output.nextLine());
            }
            fileAppender.flush();
        }
    }
}
