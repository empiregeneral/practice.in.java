package cn.pintia.zjo.practice.test.problem1949;

import cn.pintia.zjo.practice.problem1949.ErrorCorrection;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1949Test {

    @Test
    @Parameters(method = "testData")
    public void testErrorCorrect(int[][] matrix, String result){
        Scanner output = new Scanner(new ErrorCorrection(matrix));
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), result);
        }
    }

    private Object[] testData() {
        return new Object[] {
                new Object[] {new int[][]{{1, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 1}}, "OK"},
                new Object[] {new int[][]{{1, 0, 1, 0}, {0, 1, 1, 0}, {1, 1, 1, 1}, {0, 1, 0, 1}}, "Corrupt"},
                new Object[] {new int[][]{{1, 0, 1, 0}, {0, 0, 1, 0}, {1, 1, 1, 1}, {0, 1, 0, 1}}, "Change bit (2,3)"}
        };
    }
}
