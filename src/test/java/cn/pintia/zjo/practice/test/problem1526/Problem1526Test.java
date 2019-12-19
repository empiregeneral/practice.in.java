package cn.pintia.zjo.practice.test.problem1526;

import cn.pintia.zjo.practice.problem1526.BigNumber;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Scanner;


/**
 * @Author lei.zhu
 * @Description 根据测试用例的要求，设计正向的测试用例10，20，分别计算
 * 其阶乘的位数，边界用例1,10^7
 * @Date 11:03 2019/12/16
 * @Param
 * @return
 **/
@Epic("数论题")
@Feature("斯特林公式应用")
@RunWith(JUnitParamsRunner.class)
public class Problem1526Test {

    @Parameters({"10,7", "20,19", "10000000,65657060", "1,1"})
    @Test
    public void testBigNum(int n, int ans) {
        Readable readable = new BigNumber(n);
        Scanner out = new Scanner(readable);
        while (out.hasNext()) {
            Assert.assertEquals(out.nextInt(), ans);
        }
    }
}
