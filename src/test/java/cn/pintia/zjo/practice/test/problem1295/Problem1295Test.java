package cn.pintia.zjo.practice.test.problem1295;

import cn.pintia.zjo.practice.problem1295.ReverseText;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@Epic("简单题")
@Feature("字符串处理")
@RunWith(JUnitParamsRunner.class)
public class Problem1295Test {

    @Test
    @Parameters(method = "dataProvider")
    public void testReverseText(String text, String expectText) {
        Scanner output = new Scanner(new ReverseText(text));
        Assert.assertEquals(output.nextLine(), expectText);
    }

    private Object[] dataProvider() {
        return new Object[]{
                new Object[]{"money out of this scheme.", ".emehcs siht fo tuo yenom"},
                new Object[]{"madam I'm adam", "mada m'I madam"},
                new Object[]{"Frankly, I don't think we'll make much", "hcum ekam ll'ew kniht t'nod I ,ylknarF"}
        };
    }


}
