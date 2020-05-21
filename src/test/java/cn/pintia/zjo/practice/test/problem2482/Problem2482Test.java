package cn.pintia.zjo.practice.test.problem2482;

import cn.pintia.zjo.practice.problem2482.TransformBinaryToDecimal;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@Epic("基础题")
@Feature("字符串处理，二进制的IP地址转换为十进制的IP地址")
@RunWith(JUnitParamsRunner.class)
public class Problem2482Test {

    @Test
    @Parameters({"00000000000000000000000000000000,0.0.0.0", "00000011100000001111111111111111,3.128.255.255", "11001011100001001110010110000000,203.132.229.128", "01010000000100000000000000000001,80.16.0.1"})
    public void testTransformBinaryToDecimal(String bits, String expect) {
        Scanner scanner = new Scanner(new TransformBinaryToDecimal(bits));
        while(scanner.hasNextLine()) {
            Assert.assertEquals(scanner.nextLine(), expect);
        }
    }
}
