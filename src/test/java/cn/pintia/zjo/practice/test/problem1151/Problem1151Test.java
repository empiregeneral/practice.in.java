package cn.pintia.zjo.practice.test.problem1151;

import cn.pintia.zjo.practice.problem1151.WordReversal;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;


@RunWith(JUnitParamsRunner.class)
@Epic("模拟题")
@Feature("字符串反串处理，除了堆栈，其他reverse算法也可以")
public class Problem1151Test {
    @Parameters({"I am happy today,I ma yppah yadot",
                 "To be or not to be,oT eb ro ton ot eb",
                 "I want to win the practice contest,I tnaw ot niw eht ecitcarp tsetnoc",
                  })
    @Test
    public void testWordReverse(String wordsInLine, String expect) {
        Scanner output = new Scanner(new WordReversal(wordsInLine));
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), expect);
        }
    }
}
