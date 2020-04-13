package cn.pintia.zjo.practice.test.problem2136;

import cn.pintia.zjo.practice.problem2136.FindLongestOrderSequenceImp;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem2136Test {
    @Test
    @Parameters(method = "testData")
    public void testFindLOS(List<Integer> seq, String expectResult) {
        Readable readable = new FindLongestOrderSequenceImp(seq);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            Assert.assertEquals(scanner.next(), expectResult);
        }

    }

    private Object[] testData() {
        return new Object[]{
          new Object[]{Arrays.asList(new Integer[]{1, 7, 3, 5, 9, 4, 8}), "4"},
          new Object[]{Arrays.asList(new Integer[]{1, 9, 3, 8, 7, 5, 2}), "3"}
        };
    }

}
