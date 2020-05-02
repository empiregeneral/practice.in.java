package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;
import cn.pintia.zjo.practice.problem1111.Judgement;
import cn.pintia.zjo.practice.problem1111.ShowHandJudgement;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class ShowHandTest {

    private Card[] toCard(String hand) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(hand.getBytes()));
        List<Card> cards = new ArrayList<>();
        while(scanner.hasNext()) {
          cards.add(Card.valueOf(scanner.next()));
        }
        Collections.sort(cards);
        return cards.toArray(new Card[5]);
    }

    @Test
    @Parameters(method = "straightFlushProvider" )
    public void testStraightFlush(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.STRAIGHT_FLUSH.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "fourOfAKindProvider" )
    public void testFourOfAKind(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.FOUR_Of_A_KIND.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "fullHouseProvider" )
    public void testFullHouse(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.FULL_HOUSE.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "flushProvider" )
    public void testFlush(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.FLUSH.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "straightProvider" )
    public void testStraight(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.STRAIGHT.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "threeOfAKindProvider")
    public void test(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.STRAIGHT.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }


    private  Object[] straightFlushProvider() {
        return $(
                $("JH TH KH QH AH", "9D 8D JD TD QD", Judgement.BlackWin),
                $("JD KD QD KD AD", "TC JC QC KC AC", Judgement.Tie),
                $("2C 3C 4C 5C 6C", "3S 4S 6S 7S 5S", Judgement.WhiteWin)
        );
    }

    private Object[] fourOfAKindProvider() {
        return $(
                $("9D 9S 9C 9H TH", "8C 2D 2S 2C 2H", Judgement.BlackWin),
                $("AC AS AH AD KH", "KD QC QH QC QD", Judgement.WhiteWin)
        );
    }

    private Object[] fullHouseProvider() {
        return $(
                $("AS AC 9D 9S 9C", "KD KS 8D 8S 8C", Judgement.BlackWin),
                $("QD QH QC 3C 3D", "KD KH KC 2D 2H", Judgement.WhiteWin)
        );
    }

    private Object[] flushProvider() {
        return $(
                $("KS QS AS JS 3S", "AD KD QD 8D 9D", Judgement.BlackWin),
                $("KS QS AS JS 3S", "KH QH AH JH 3H", Judgement.Tie),
                $("2D 3D 9D 8D 7D", "TH KH QH 3H 2H", Judgement.WhiteWin)
        );
    }

    private Object[] straightProvider() {
        return $(
           $("AS KS JD TD QC", "2S 3S 4D 6C 5H", Judgement.BlackWin),
           $("AS KS JD TD QC", "AH KD QH JD TC", Judgement.Tie),
           $("3H 4D 5C 6H 7S", "4S 5D 6C 7C 8C", Judgement.WhiteWin)
        );
    }

    private Object[] threeOfAKindProvider() {
        return $(
                $(),
                $(),
                $()
        );
    }

    private Object[] twoPairsProvider() {
        return $(
                $(),
                $(),
                $()
        );
    }

    private Object[] pairProvider() {
        return $(
                $(),
                $(),
                $()
        );
    }

    private Object[] highCardProvider() {
        return $(
                $(),
                $(),
                $()
        );
    }
}
