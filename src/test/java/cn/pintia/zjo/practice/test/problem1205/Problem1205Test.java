package cn.pintia.zjo.practice.test.problem1205;

import cn.pintia.zjo.practice.problem1205.MartianAddition;
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
  * @Description 测试MartainAdditional类，
  * 求解火星人的20进制加法两个数的加法，要从测试用例倒推，细节还是多领悟。
  * @Date 23:10 2020/3/28
  * @Param String numOne, String numTwo, String expectResult
  * @return void
 **/
@RunWith(JUnitParamsRunner.class)
@Epic("模拟题")
@Feature("模拟实现二十进制加法，实际上是字符串的处理")
public class Problem1205Test {

    @Parameters({
            "1234567890,abcdefghij,bdfi02467j",
            "99999jjjjj,9999900001,iiiij00000",
            "jjjjjjjjjj,0000000001,10000000000",
            ",j,j"
    })
    @Test
    public void matriansPlus(String one, String two, String result) {
        Scanner scanner = new Scanner(new MartianAddition(one, two));
        while(scanner.hasNextLine()) {
            Assert.assertEquals(scanner.nextLine(), result);
        }
    }
}
