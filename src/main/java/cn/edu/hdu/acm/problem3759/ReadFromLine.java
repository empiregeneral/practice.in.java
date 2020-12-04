package cn.edu.hdu.acm.problem3759;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReadFromLine implements IHandScore {

    private String input;
    private int[] ranks = new int[Hand.HAND_SIZE];
    private int[] suits = new int[Hand.HAND_SIZE];


    public ReadFromLine(String readLine) {
        this.input = readLine;
        String[] cards = input.split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < Hand.HAND_SIZE; i++) {
            String card = cards[i];
            assert card.length() == 2;
            ranks[i] = Hand.R.indexOf(card.charAt(0));
            suits[i] = Hand.S.indexOf(card.charAt(1));
            assert ranks[i] >= 0 && suits[i] >= 0;
            assert set.add(card);
        }

        Arrays.sort(ranks);
    }


    @Override
    public int hand() {
        int hand = 0;
        for (int i = 0; i < Hand.HAND_SIZE; i++) {
            hand = Hand.setCard(hand, i, ranks[i]);
        }

        boolean flush = true;
        for (int i = 1; i < Hand.HAND_SIZE; i++) {
            flush = flush & (suits[i] == suits[i-1]);
        }

        if (flush) {
            hand = Hand.setFlush(hand);
        }
        return hand;
    }
}
