package cn.edu.hdu.acm.problem1629;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            DealWithRoundOfCards deal = new DealWithRoundOfCards(input.nextLine());
            Readable readable = new PsychicPokerPlayer(deal.getHandCards(), deal.getDeckCards());
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}

class DealWithRoundOfCards {
    private String roundOfCards;
    private List<Card> handCards;
    private List<Card> deckCards;
    private Pattern pattern = Pattern.compile("\\s");
    private final String SEPARATOR = " ";
    private final String REPLACEMENT = ",";
    private final int startSearchIdx = 14;

    public DealWithRoundOfCards(String roundOfCards) {
        this.roundOfCards = roundOfCards;
        Matcher matcher = pattern.matcher(this.roundOfCards);
        StringBuffer sb = new StringBuffer();
        if (matcher.find(startSearchIdx)) {
            matcher.appendReplacement(sb, REPLACEMENT);
        }
        matcher.appendTail(sb);
        String[] cards = sb.toString().split(REPLACEMENT);
        this.handCards = toCardList(cards[0]);
        this.deckCards = toCardList(cards[1]);
    }

    /**
     * 输入5个以空格分隔的字符串，返回List<Card>类型的队列</>
     * @param cards "AH AD AS AC KH"
     * @return List<Card></>
     */
    private List<Card> toCardList(String cards) {
        List<Card> cardList = new ArrayList<>();
        for (String card: cards.split(SEPARATOR)) {
            cardList.add(Card.valueOf(card));
        }
        return cardList;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public List<Card> getDeckCards() {
        return deckCards;
    }
}


 final class RegexUtil {
    public static String replaceNPattern(String regex, CharSequence input, String replacement, int N) {
        if (null == regex || regex.isEmpty()) {
            return input.toString();
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; matcher.find(); ++i) {
            if (i == N) {
                matcher.appendReplacement(sb, replacement);
                matcher.appendTail(sb);
            }
        }

        if (0 == sb.length()) {
            return input.toString();
        }

        return sb.toString();
    }
}
