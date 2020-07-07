package cn.pintia.zjo.practice.test.problem1951;


import cn.pintia.zjo.practice.problem1951.FindGoldbachEquationImp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@Epic("数论题")
@Feature("用数据和等式展现哥德巴赫猜想在1百万个正整数内是正确的")
@RunWith(JUnitParamsRunner.class)
public class Problem1951Test {

    @Test
    @Parameters({"6,6 = 3 + 3", "900000,900000 = 19 + 899981", "1000000,1000000 = 17 + 999983"})
    public void testEquationSolution(int num, String equation) throws Exception {
        Readable readable = new FindGoldbachEquationImp(num);
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), equation);
        }
    }
}
