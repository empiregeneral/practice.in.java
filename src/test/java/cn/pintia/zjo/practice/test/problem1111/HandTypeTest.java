package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.Card;
import cn.pintia.zjo.practice.problem1111.HandType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandTypeTest extends TestUtil {

    @Test
    public void testContains() {
//        Assert.assertTrue(contains(HandType.TWO_PAIRS, _2S, _AS, _3D, _2D, _AD, _4S, _5H));
//        Assert.assertTrue(contains(HandType.STRAIGHT, _2S, _AS, _3D, _2D, _AD, _4S, _5H));
        Assert.assertTrue(contains(HandType.FLUSH, _TH, _JH, _QC, _QD, _QS, _QH,
                _KH, _AH, _2S, _6S));
    }


    private boolean contains(HandType handType, Card... cards) {
        List<Card> hand = new ArrayList<>(2);
        List<Card> deck = new ArrayList<>(5);

        for (int i = 0; i < 5; i++) {
            hand.add(cards[i]);
        }

        for (int i = 5; i < 10; i++) {
            deck.add(cards[i]);
        }

        return handType.contains(hand, deck);
    }

}
