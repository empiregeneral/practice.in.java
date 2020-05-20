package cn.pintia.zjo.practice.test.problem2136;

import cn.pintia.zjo.practice.problem2136.FindLongestOrderSequenceImp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Epic("动态规划")
@Feature("DP经典问题：求取最长递增子序列")
@RunWith(JUnitParamsRunner.class)
public class Problem2136Test {
    @Test
    @Parameters(method = "testData")
    public void testFindLOS(List<Integer> seq, String expectResult) {
        Readable readable = new FindLongestOrderSequenceImp(seq);
        Scanner scanner = new Scanner(readable);
        while (scanner.hasNext()) {
            Assert.assertEquals(scanner.next(), expectResult);
        }

    }

    private Object[] testData() {
        return new Object[]{
                new Object[]{Arrays.asList(new Integer[]{1, 7, 3, 5, 9, 4, 8}), "4"},
                new Object[]{Arrays.asList(new Integer[]{1, 9, 3, 8, 7, 5, 2}), "3"},
                new Object[]{Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7}), "7"},
                new Object[]{Arrays.asList(new Integer[]{7, 6, 5, 4, 3, 2, 1}), "1"}
        };
    }

}
