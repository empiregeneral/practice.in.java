package cn.edu.hdu.acm.problem3759;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.stream.Stream;

@RunWith(JUnitParamsRunner.class)
public class HandTest {

    /**
     *
     * @param input card的rank值，一般indexOf("23456789TJQKA")
     * @param expect
     */
    @Test
    @Parameters({"2 3 4 5 6,414770", "12 11 8 12 8,838536"})
    public void testSetHand(String input, int expect) {
        int hand = 0;
        int[] ranks = stringToIntArray(input);
        for (int j = 0; j < Hand.HAND_SIZE; j++) {
            hand = Hand.setCard(hand, j, ranks[j]);
        }
        Assert.assertEquals(hand, expect);
    }

    @Test
    @Parameters({"414770,6 5 4 3 2"})
    public void testGetHand(int hand, String expect) {
        int[] rankInCards = new int[Hand.HAND_SIZE];
        for (int c = Hand.HAND_SIZE; --c >= 0;) {
            rankInCards[c] = Hand.getCard(hand, c);
        }
        Assert.assertEquals(Arrays.toString(rankInCards), Arrays.toString(stringToIntArray(expect)));
    }

    @Test
    @Parameters({"414770,0,4"})
    public void testSwapCard(int hand, int i, int j) {
        System.out.println(Hand.swapCard(hand, i, j));
    }

    @Test
    @Parameters({"414770,2,0", "799248,4,3"})
    public void testMoveCard(int hand, int to, int from) {
        System.out.println(Hand.moveCard(hand, to, from));
    }


    @Test
    @Parameters({"414770"})
    public void testSetFlush(int hand) {
        System.out.println(Hand.setFlush(hand));
    }

    @Test
    public void testACERolledStraight() {
        System.out.println(Hand.ACE_ROLLED_STRAIGHT);
    }

    @Test
    public void testStraightRankMapByAceRolled() {
        Hand.HandScore score = new Hand.HandScore(Hand.ACE_ROLLED_STRAIGHT);
        System.out.println(score.map);
    }



    @Test
    @Parameters({"414770,STRAIGHT", "1294864,STRAIGHT_FLUSH"})
    public void testStraightRankMap(int hand, Hand.Ranking expectRanking) {
        Hand.HandScore score = new Hand.HandScore(hand);
        System.out.println(score.map);
       Assert.assertEquals(score.ranking,expectRanking);
    }

    @Test
    @Parameters("1323536")
    public void test(int hand) {

        System.out.println(Hand.ACE_ROLLED_STRAIGHT);
    }

    @Test
    @Parameters({"2S 3H 9S 8D 5C,484112", "AS KH QS JD 9C,834199"})
    public void testHighCardRankMap(String cards, int mapResult) {
        IHandScore score = new ReadFromLine(cards);
        int hand = score.hand();
        Assert.assertEquals(Hand.Ranking.HIGH_CARD.map(hand), mapResult);
    }

    @Test
    @Parameters({"AS KC QD JC AH,838569", "2C 3C 2D 4D 5H,801"})
    public void testOnePairRankMap(String cards, int mapResult) {
        IHandScore score = new ReadFromLine(cards);
        int hand = score.hand();
        Assert.assertEquals(Hand.Ranking.ONE_PAIR.map(hand), mapResult);
    }

    @Test
    @Parameters({"AS AC KH QS KD,838586", "3C 3D 2H 2D 4S,69634"})
    public void testTwoPairRankMap(String cards, int mapResult) {
        IHandScore score = new ReadFromLine(cards);
        int hand = score.hand();
        Assert.assertEquals(Hand.Ranking.TWO_PAIRS.map(hand), mapResult);
    }

    @Test
    @Parameters({"AS AH AD KS QD,838842", "2D 2H 2S 3D 4H,33", "2S 2H 2C 3S 4D,33"})
    public void testThreeOfKindRankMap(String cards, int mapResult) {
        IHandScore score = new ReadFromLine(cards);
        int hand = score.hand();
        Assert.assertEquals(Hand.Ranking.THREE_OF_A_KIND.map(hand), mapResult);
    }

    @Test
    @Parameters({"AC KC JC QC TC,989323", "AC 2C 3C 4C 5C,9876"})
    public void testFlushStraightRankMap(String cards, int mapResult) {
        IHandScore score = new ReadFromLine(cards);
        int hand = score.hand();
        System.out.println(hand);
    }



    private int[] stringToIntArray(String input) {
        Stream<String> stream = Arrays.stream(input.split(" "));
        int[] result = stream.mapToInt(e -> Integer.parseInt(e)).toArray();
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        return result;
    }

}
