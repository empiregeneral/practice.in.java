package cn.pintia.zjo.practice.test.problem1975;

import cn.pintia.zjo.practice.problem1975.DrawSierpinskiFractal;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1975Test {

    @Test
    @Parameters({"1","2","3","4","5"})
    public void testDrawSierpinskiFractal(int scale) {
        Readable readable = new DrawSierpinskiFractal(scale);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }


}
