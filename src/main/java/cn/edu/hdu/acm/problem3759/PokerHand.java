package cn.edu.hdu.acm.problem3759;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PokerHand {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            String inputLine = input.nextLine();
            CardsFromLine cards = new CardsFromLine(inputLine);
            IHandScore blackHand = new ReadFromLine(cards.getBlackCards());
            int handBlack = blackHand.hand();
            IHandScore whiteHand = new ReadFromLine(cards.getWhiteCards());
            int handWhite = whiteHand.hand();
            Scanner output = new Scanner(new Judgement(handBlack, handWhite));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }

    static class Judgement implements Comparator<Integer>, Readable {
        int handBlack;
        int handWhite;
        int count = 1;

        public Judgement(int handBlack, int handWhite) {
            this.handBlack = handBlack;
            this.handWhite = handWhite;
        }

        @Override
        public int read(CharBuffer cb) throws IOException {
            if (--count < 0) {
                return -1;
            }

            int result = compare(Solvable.solution(this.handBlack), Solvable.solution(this.handWhite));

            if (result > 0) {
                cb.append("Black wins.");
            } else if (result == 0) {
                cb.append("Tie.");
            } else {
                cb.append("White wins.");
            }

            return 10;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    static class CardsFromLine {
        String inputLine;
        String blackCards;
        String whiteCards;

        public CardsFromLine(String inputLine) {
            this.inputLine = inputLine;
            String[] cards = RegexUtil.replaceSome(" ", this.inputLine, ",", 4).split(",");
            this.blackCards = cards[0];
            this.whiteCards = cards[1];
        }

        public String getWhiteCards() {
            return whiteCards;
        }

        public String getBlackCards() {
            return blackCards;
        }
    }

    static class RegexUtil {
        static String replaceSome(String regex, String input, String replacement, int n) {
            if (null == regex || regex.isEmpty()) {
                return input;
            }
            if (0 == n) {
                return input.replaceFirst(regex, replacement);
            }

            Pattern r = Pattern.compile(regex);
            Matcher m = r.matcher(input);
            int i = 0;
            StringBuffer buffer = new StringBuffer();
            while (i <= n && m.find()){
                if (i == n){
                    m.appendReplacement(buffer, replacement);
                    m.appendTail(buffer);
                }
                ++i;
            }
            if (0 == buffer.length()) {
                buffer.append(input);
            }

            return buffer.toString();
        }
    }
}
