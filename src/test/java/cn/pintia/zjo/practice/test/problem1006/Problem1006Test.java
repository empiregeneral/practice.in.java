package cn.pintia.zjo.practice.test.problem1006;

import cn.pintia.zjo.practice.problem1006.DecipherFacade;
import cn.pintia.zjo.practice.problem1006.DecipherMachineImp;
import cn.pintia.zjo.practice.problem1006.TransformCodeImp;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @ClassName: TestProblem1006
 * @Description: zju 1006 Test
 * @Author :lei.zhu
 * @Date 2019/12/13 16:06
 * @Version 1.0
 **/
@RunWith(JUnitParamsRunner.class)
@Epic("模拟题")
@Feature("加密解密应用")
public class Problem1006Test {
    @Parameters({"5,cs.,cat",
                 "101,thqqxw.lui.qswer,this_is_a_secret",
                 "3,b_ylxmhzjsys.virpbkr,beware._dogs_barking"})
    @Test
    public void testDoTheTwist(int key, String cipherText, String plainText) {
        DecipherFacade facade = new DecipherFacade(new DecipherMachineImp(key, cipherText),
                                                   new TransformCodeImp(cipherText));
        Assert.assertEquals(facade.decipher(key, cipherText), plainText);
    }

}
