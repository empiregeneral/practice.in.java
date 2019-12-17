package cn.pintia.zjo.practice.test.problem1797;

import cn.pintia.zjo.practice.problem1797.LeastCommonMultiple;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @ClassName: TestProblem1797
 * @Description: zju 1797测试用例，要设计出多个数字相乘出现溢出的情况的用例
 * @Author :lei.zhu
 * @Date 2019/12/16 15:12
 * @Version 1.0
 **/
@RunWith(JUnitParamsRunner.class)
public class Problem1797Test {

    @Parameters(method = "testData")
    @Test
    public void testLeastCommonMultiply(int[] arr, int ans) {
        LeastCommonMultiple lcm = new LeastCommonMultiple(arr);
        Assert.assertEquals(lcm.getLcm(), ans);
    }

    private Object[] testData() {
        return new Object[] {
          new Object[]{new int[]{5, 7, 15}, 105},
          new Object[]{new int[]{4, 10296, 936, 1287, 792, 1}, 10296},
          new Object[]{new int[]{105, 27, 10240, 819, 960, 980}, 176117760}
        };
    }
}
