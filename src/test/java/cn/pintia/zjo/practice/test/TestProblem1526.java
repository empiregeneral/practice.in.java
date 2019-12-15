package cn.pintia.zjo.practice.test;

import cn.pintia.zjo.practice.problem1526.BigNumber;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class TestProblem1526 {

    @Parameters({"10,7", "20,19", "25,26"})
    @Test
    public void testBigNum(int n, int ans) {
        Readable readable = new BigNumber(n);
        Scanner out = new Scanner(readable);
        while (out.hasNextInt()) {
            Assert.assertEquals(out.nextInt(), ans);
        }
    }
}
