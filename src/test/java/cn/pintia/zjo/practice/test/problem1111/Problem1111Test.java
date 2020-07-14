package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.ShowHandInDeck;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
@Epic("模拟题")
@Feature("牌面类型比较测试和牌面大小的比较测试")
public class Problem1111Test {

    @Test
//    @Parameters({"5C 5D 2C 2D AS,2S 2H 3C 3D AD,Black wins.",
//                 "AH KH QH JH 3C,2S 2H 2C 3H TS,White wins.",
//                 "AH KH JH QH TH,AS KS JS TS QS,Tie.",
//                  "AS KS AH AD KD,JS KS QS 9S TS,White wins."})
    @FileParameters(value = "src/test/resources/data_zjo_1111.csv", mapper = StringMapper.class)
    public void testJudgement(String blackHands, String whiteHands, String result) {
        Readable readable = new ShowHandInDeck(blackHands, whiteHands);
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), result);
        }
    }
}
