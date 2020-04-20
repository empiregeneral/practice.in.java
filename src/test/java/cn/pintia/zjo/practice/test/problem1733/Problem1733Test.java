package cn.pintia.zjo.practice.test.problem1733;

import cn.pintia.zjo.practice.problem1733.CommonSubsequence;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1733Test {

    @Test
    @Parameters({"abcfbc,abfcab,4", "programming,contest,2", "abcd,mnp,0"})
    public void testCommonSubsequence(String one, String two, String expect) {
        Readable readable = new CommonSubsequence(one, two);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            Assert.assertEquals(scanner.next(), expect);
        }
    }
}
