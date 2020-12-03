package cn.edu.hdu.acm.problem3759;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HandTest {

    @Test
    @Parameters({"0,0,0", "0,1,1", "16,2,2", "528,3,3", "12816,4,4"})
    public void testSetHand(int hand, int i, int rank) {
        System.out.println(Hand.setCard(hand, i, rank));
    }

    @Test
    @Parameters({"274960"})
    public void testSetFlush(int hand) {
        System.out.println(Hand.setFlush(hand));
    }


}
