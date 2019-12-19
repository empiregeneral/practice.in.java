package cn.pintia.zjo.practice.test.problem1151;

import cn.pintia.zjo.practice.problem1151.WordReversal;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;


@RunWith(JUnitParamsRunner.class)
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
