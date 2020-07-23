package cn.pintia.zjo.practice.test.problem1962;

import cn.pintia.zjo.practice.problem1962.CountFibsInRangeImp;
import cn.pintia.zjo.practice.problem1962.Machine;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigInteger;
import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1962Test {

    private BigInteger[] fibs = Machine.createFibTable(512);

    @Test
    @Parameters({"10,100,5", "1234567890,9876543210,4", "314159265358979323846,3141592653589793238462643383279502884197169399375105820974944,192"})
    public void testCountFibInRange(String a, String b, String expect) {
        Scanner output = new Scanner(new CountFibsInRangeImp(new BigInteger(a), new BigInteger(b), fibs));
        while(output.hasNextLine()) {
            Assert.assertEquals(output.next(), expect);
        }
    }
}
