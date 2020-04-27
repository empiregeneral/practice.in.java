package cn.pintia.zjo.practice.problem1111;


import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Main implements Readable{

    private String blackHands;
    private String whiteHands;
    private HandType handType4Black;
    private HandType handType4White;
    private int count = 1;

    public Main(String blackHands, String whiteHands) {
        this.blackHands = blackHands;
        this.whiteHands = whiteHands;
        handType4Black = new IHandTypeImp(blackHands).getHandType();
        handType4White = new IHandTypeImp(whiteHands).getHandType();
    }

    public static void main(String[] args) {
        String Black = "2H 3D 5S 9C AD";
        String White = "2C 7D 4S 8C AH";

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
            cb.append("Tie.");
        } else if (handType4Black.compareTo(handType4White) > 0) {
            cb.append("Black Win.");
        } else {
            cb.append("White Win.");
        }

        return 10;
    }
}
