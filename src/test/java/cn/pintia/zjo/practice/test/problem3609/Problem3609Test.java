package cn.pintia.zjo.practice.test.problem3609;

import cn.pintia.zjo.practice.problem3609.ModuleInverse;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

/**
 * @ClassName: Problem3609Test
 * @Description: TODO
 * @Author :lei.zhu
 * @Date 2019/12/17 17:19
 * @Version 1.0
 **/
@RunWith(JUnitParamsRunner.class)
public class Problem3609Test {
    @Parameters({"3,11,4", "4,12,Not Exist", "5,13,8"})
    @Test
    public void testModuleInverse(int a, int m, String ans) {
        Readable readable = new ModuleInverse(a, m);
        Scanner output = new Scanner(readable);
        // System.out.println(output.nextLine());
        Assert.assertEquals(output.nextLine(), ans);
    }
}
