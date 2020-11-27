package cn.edu.hdu.acm.problem1629;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String SEPARATOR = " ";
    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            String[] cards = input.nextLine().split(SEPARATOR);
            List<Card> handCards = new ArrayList<>();
            List<Card> deckCards = new ArrayList<>();
            for (int i = 0; i < cards.length; i++) {
                if (i < 5) {
                    handCards.add(Card.valueOf(cards[i]));
                } else {
                    deckCards.add(Card.valueOf(cards[i]));
                }
            }

            Readable readable = new PsychicPokerPlayer(handCards, deckCards);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
