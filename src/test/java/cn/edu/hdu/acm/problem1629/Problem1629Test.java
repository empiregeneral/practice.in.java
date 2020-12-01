package cn.edu.hdu.acm.problem1629;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@RunWith(JUnitParamsRunner.class)
public class Problem1629Test {

    @Parameters({"TH JH QC QD QS QH KH AH 2S 6S,straight-flush"})
    @Test
    public void testPsychicPokerPlayer(String roundOfCards, String bestHand) {
        Pattern pattern = Pattern.compile(bestHand);
        DealWithRoundOfCards deal = new DealWithRoundOfCards(roundOfCards);
        Scanner output = new Scanner(new PsychicPokerPlayer(deal.getHandCards(), deal.getDeckCards()));
        while(output.hasNextLine()) {
            Assert.assertTrue(pattern.matcher(output.nextLine()).find());
        }
    }

    @Test
    @Parameters({"2H 2S 3H 3S 3C 2D 3D 6C 9C TH,four-of-a-kind"})
    public void testGamblePlay(String roundOfCards, String expect) {
        Gambler gambler = new Gambler();
        DealWithRoundOfCards deal = new DealWithRoundOfCards(roundOfCards);
        HandType handType = gambler.playCards(deal.getHandCards(), deal.getDeckCards());
        Assert.assertEquals(handType.getDescription(), expect);
    }

    class DealWithRoundOfCards {
        private String roundOfCards;
        private List<Card> handCards = new ArrayList<>();
        private List<Card> deckCards = new ArrayList<>();

        public DealWithRoundOfCards(String roundOfCards) {
            this.roundOfCards = roundOfCards;
            Scanner input = new Scanner(new ByteArrayInputStream(this.roundOfCards.getBytes()));
            for (int i = 0; input.hasNext(); i++) {
                if (i < 5) {
                    handCards.add(Card.valueOf(input.next()));
                } else {
                    deckCards.add(Card.valueOf(input.next()));
                }
            }
        }

        public List<Card> getHandCards() {
            return handCards;
        }

        public List<Card> getDeckCards() {
            return deckCards;
        }
    }
}
