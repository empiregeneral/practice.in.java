package cn.pintia.zjo.practice.test.problem1095;

import cn.pintia.zjo.practice.problem1095.DecorateHumbleNumber;
import cn.pintia.zjo.practice.problem1095.Generate;
import cn.pintia.zjo.practice.problem1095.HumbleNumberGenerate;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
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
