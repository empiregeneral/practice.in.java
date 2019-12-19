package cn.pintia.zjo.practice.test.Problem1048;

import cn.pintia.zjo.practice.problem1048.FinancialManagement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * @ClassName: Problem1048Test
 * @Description: Test zjo problem 1048
 * @Author :lei.zhu
 * @Date 2019/12/17 15:09
 * @Version 1.0
 **/
@RunWith(JUnitParamsRunner.class)
@Epic("基础题")
@Feature("就是求解输入数据的平均数")
public class Problem1048Test {
    @Parameters(method = "testData")
    @Test
    public void testFinancialManagement(double[] balancesInMonthly, CharSequence mean) {
        Readable readable = new FinancialManagement(Arrays.stream(balancesInMonthly));
        Scanner out = new Scanner(readable);
        Assert.assertEquals(out.next(), mean);
    }

    private Object[] testData() {
        double[] arr = new double[]{100.00, 489.12, 12454.12, 1234.10, 823.05,
                                    109.20, 5.27, 1542.25, 839.18, 83.99,
                                    1295.01, 1.75};
        return new Object[]{new Object[]{arr, "$1581.42"}};
    }
}
