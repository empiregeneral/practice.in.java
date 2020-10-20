package cn.pintia.zjo.practice.test.problem1962;

import cn.pintia.zjo.practice.problem1962.Main;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigInteger;

@RunWith(JUnitParamsRunner.class)
public class Problem1962Test {

    private BigInteger[] fibs = Main.createTable(512);

    @Test
    @Parameters({"10,100,5", "1234567890,9876543210,4", "314159265358979323846,3141592653589793238462643383279502884197169399375105820974944,192"})
    public void testCountFibInRange(String lower, String upper, int expect) {
        BigInteger a = new BigInteger(lower);
        BigInteger b = new BigInteger(upper);
        Assert.assertEquals(Main.countFibsInRange(fibs, a, b), expect);
    }
}
