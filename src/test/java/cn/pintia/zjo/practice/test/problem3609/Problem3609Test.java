package cn.pintia.zjo.practice.test.problem3609;

import cn.pintia.zjo.practice.problem3609.ModuleInverse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

/**
 * @ClassName: Problem3609Test
 * @Description: 测试ModuleInverse类
 * @Author :lei.zhu
 * @Date 2019/12/17 17:19
 * @Version 1.0
 **/
@RunWith(JUnitParamsRunner.class)
@Epic("数论题")
@Feature("求解mod运算的逆元，注意异常情况")
public class Problem3609Test {
    @Parameters({"3,11,4", "4,12,Not Exist", "5,13,8"})
    @Test
    public void testModuleInverse(int a, int m, String ans) {
        Readable readable = new ModuleInverse(a, m);
        Scanner output = new Scanner(readable);
        // System.out.println(output.nextLine());
        /** 如果使用next()会遇到空格自动输出，所以使用nextLine()输出 */
        Assert.assertEquals(output.nextLine(), ans);
    }
}
