package cn.edu.hdu.acm.problem1629;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

public class PsychicPokerPlayer implements Readable{
    private int count = 1;
    private HandType bestHandType;
    private List<Card> handCards;
    private List<Card> deckCards;
    private Gambler gambler = new Gambler();

    public PsychicPokerPlayer(List<Card> handCards, List<Card> deckCards) {
        this.handCards = handCards;
        this.deckCards = deckCards;
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        bestHandType = gambler.playCards(this.handCards, this.deckCards);
        cb.append("Hand: " + cardListInfo(handCards)  + "Deck: " + cardListInfo(deckCards) + "Best hand: " + bestHandType.getDescription());

        return 10;
    }

    private String cardListInfo(List<Card> cardList) {
        StringBuilder sb = new StringBuilder("");
        for (Card card : cardList) {
            sb.append(card.toString() + " ");
        }
        return sb.toString();
    }
}
