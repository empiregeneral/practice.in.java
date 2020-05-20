package cn.pintia.zjo.practice.test.problem1095;

import cn.pintia.zjo.practice.problem1095.DecorateHumbleNumber;
import cn.pintia.zjo.practice.problem1095.Generate;
import cn.pintia.zjo.practice.problem1095.HumbleNumberGenerate;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
@Epic("动态规划")
@Feature("求解丑数，生成丑数的过程就是动态规划递推的过程，注意输出用装饰器模式修饰")
public class Problem1095Test {
    @Test
    @FileParameters(value = "src/test/resources/data_zjo_1095.csv", mapper = NumberMapper.class)
    public void testPrintHumbleNumber(int num, String expect) {
        Generate generate = new HumbleNumberGenerate(20000);
        Scanner output = new Scanner(new DecorateHumbleNumber(num, generate.createTable()));
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), expect);
        }
    }
}
