package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.HandType;
import cn.pintia.zjo.practice.problem1111.IHandType;
import cn.pintia.zjo.practice.problem1111.IHandTypeImp;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class IHandTypeTest {

    @Test
    @Parameters(method = "dataProvider")
    public void testGetHandType(String cards, HandType handType) {
        IHandType machine = new IHandTypeImp(cards);
        Assert.assertEquals(machine.getHandType(), handType);
    }

    private Object[] dataProvider() {
        return $(
                $("3C KD 2S QC AH", HandType.HIGH_CARD),
                $("2C KD 2S QC AH", HandType.PAIR),
                $("KS KD 2S 2D 3H", HandType.TWO_PAIRS),
                $("AS AH AC KS JD", HandType.THREE_OF_A_KIND),
                $("2C 3D 4S 5H 6H", HandType.STRAIGHT),
                $("AH 3H 2H KH JH", HandType.FLUSH),
                $("KS KC AH AC AD", HandType.FULL_HOUSE),
                $("2C 2D 2H 2S KS", HandType.FOUR_Of_A_KIND),
                $("TH JH QH KH AH", HandType.STRAIGHT_FLUSH)
        );
    }
}
