package cn.pintia.zjo.practice.problem1111;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int cardsInHand = 5;
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            StringBuilder blackSb = new StringBuilder("");
            for (int i = 1; i <= cardsInHand; i++) {
                blackSb.append(input.next() + " ");
            }
            String blackHands = blackSb.toString();

            StringBuilder whiteSb = new StringBuilder("");
            for (int i = 1; i <= cardsInHand; i++) {
                whiteSb.append(input.next() + " ");
            }
            String whiteHands = whiteSb.toString();

            Readable readable = new ShowHandInDeck(blackHands, whiteHands);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
