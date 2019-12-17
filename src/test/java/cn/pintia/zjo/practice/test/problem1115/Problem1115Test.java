package cn.pintia.zjo.practice.test.problem1115;

import cn.pintia.zjo.practice.problem1115.DigitRoot;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

/**
 * @ClassName: Problem1115Test
 * @Description: 测试zjo problem 1115中DigitRoot类
 * @Author :lei.zhu
 * @Date 2019/12/13 13:46
 * @Version 1.0
 **/
@RunWith(JUnitParamsRunner.class)
public class Problem1115Test {

    @Parameters({"24,6", "39,3", "9223372036854774807,6", "9223372036854774808,7"})
    @Test
    public void testDigitRoot(String value, String expect) {
        Readable readable = new DigitRoot(value);
        Scanner scanner = new Scanner(readable);
        while (scanner.hasNext()) {
            Assert.assertEquals(scanner.next(), expect);
        }
    }
}
