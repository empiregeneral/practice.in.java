package cn.pintia.zjo.practice.problem1111;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main implements Readable{

    private String blackHands;
    private String whiteHands;
    private HandType handType4Black;
    private HandType handType4White;
    private HandType type;
    private int count = 1;

    public Main(String blackHands, String whiteHands) {
        this.blackHands = blackHands;
        this.whiteHands = whiteHands;
        handType4Black = new IHandTypeImp(blackHands).getHandType();
        handType4White = new IHandTypeImp(whiteHands).getHandType();

    }

    private Card[] toCards(String playerhands) {
        List<Card> cardList = new ArrayList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(playerhands.getBytes()));
        while(scanner.hasNext()) {
            cardList.add(Card.valueOf(scanner.next()));
        }
        Collections.sort(cardList);
        return cardList.toArray(new Card[5]);
    }

    public static void main(String[] args) {
        String Black = "2D 3D 4D 5D 6D";
        String White = "TH JH QH KH AH";

        Readable readable = new Main(Black, White);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        if (handType4Black.compareTo(handType4White) == 0 ) {
            Judgement judgement = ShowHandJudgement.STRAIGHT_FLUSH.judgement(toCards(blackHands), toCards(whiteHands));
            cb.append(judgement.getDescription());
        } else if (handType4Black.compareTo(handType4White) > 0) {
            cb.append("Black Win.");
        } else {
            cb.append("White Win.");
        }

        return 10;
    }
}
