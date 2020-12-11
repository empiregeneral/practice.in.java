package cn.edu.hdu.acm.problem3759;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class Problem3759 {
    @Test
    @FileParameters(value = "src/test/resources/data_hdu_3759.csv", mapper = StringMapper.class)
    public void testHandsOfPoker(String handOfCards, int position) {
        IHandScore iHandScore = new ReadFromLine(handOfCards);
        int hand = iHandScore.hand();
        Assert.assertEquals(position,Solvable.solution(hand));
    }

}
