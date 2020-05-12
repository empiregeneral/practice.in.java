package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;
import cn.pintia.zjo.practice.problem1111.Judgement;
import cn.pintia.zjo.practice.problem1111.ShowHandJudgement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
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
@Epic("模拟题")
@Feature("相同类型的牌面大小测试")
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
    @Story("同等类型同花顺的牌面测试")
    public void testStraightFlush(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.STRAIGHT_FLUSH.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "fourOfAKindProvider" )
    @Story("4条类型的牌面大小测试")
    public void testFourOfAKind(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.FOUR_Of_A_KIND.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "fullHouseProvider" )
    @Story("葫芦类型的牌面大小测试")
    public void testFullHouse(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.FULL_HOUSE.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "flushProvider" )
    @Story("同花类型的牌面大小测试")
    public void testFlush(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.FLUSH.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "straightProvider" )
    @Story("顺子类型的牌面大小测试")
    public void testStraight(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.STRAIGHT.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "threeOfAKindProvider")
    @Story("三条类型的牌面大小测试")
    public void testThreeOfAKind(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.THREE_OF_A_KIND.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "twoPairsProvider")
    @Story("两对类型的牌面大小测试")
    public void testTwoPairs(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.TWO_PAIRS.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "pairProvider")
    @Story("对子类型的牌面大小测试")
    public void testPair(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.PAIR.judgement(toCard(blackHands), toCard(whiteHands)), result);
    }

    @Test
    @Parameters(method = "highCardProvider")
    @Story("高牌类型的牌面大小测试")
    public void testHighCard(String blackHands, String whiteHands, Judgement result) {
        Assert.assertEquals(ShowHandJudgement.HIGH_CARD.judgement(toCard(blackHands), toCard(whiteHands)), result);

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
                $("3C 3S 3H 3D KH", "KD QC QH QC QD", Judgement.WhiteWin)
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
                $("AS AD AH 3C 2H", "KS KH KD QH JC", Judgement.BlackWin),
                $("2C 2S 2H AS KS", "3S 3D 3H KD QC", Judgement.WhiteWin)
        );
    }

    private Object[] twoPairsProvider() {
        return $(
                $("AS AD JC 2S 2D", "KS KC QC 3D 3H", Judgement.BlackWin),
                $("AS AC KC QC QD", "AD AH KD QH QS", Judgement.Tie),
                $("AS AD JH 2S 2D", "AD AH 3S 3D TH", Judgement.WhiteWin),
                $("AS AD KS KD QS", "AC AH KC KH JS", Judgement.BlackWin),
                $("KS KD JS JD TC", "KC KH JC JH QC", Judgement.WhiteWin)
        );
    }

    private Object[] pairProvider() {
        return $(
                $("TS TD 2S 3C 6S", "TH TC 2H 3H 5S", Judgement.BlackWin),
                $("TS TD 2S 3C 6S", "TH TC 2H 3D 6D", Judgement.Tie),
                $("TS TH AC KC QD", "JS JH TD 2C 3D", Judgement.WhiteWin)
        );
    }

    private Object[] highCardProvider() {
        return $(
                $("AS KH JC 3S TS", "AC KD JD TD 2C", Judgement.BlackWin),
                $("TD 2S 3H 7S 8D", "TC 2D 3C 7H 8C", Judgement.Tie),
                $("9C 8D 7C 2H 3C", "TH 2C 3H 4S 5D", Judgement.WhiteWin)
        );
    }
}
