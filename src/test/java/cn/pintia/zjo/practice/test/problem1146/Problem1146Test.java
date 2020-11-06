package cn.pintia.zjo.practice.test.problem1146;

import cn.pintia.zjo.practice.problem1146.LcDisplay;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1146Test {

    @Test
    @Parameters({"3,1234567890", "2,08080808", "9,88888"})
    public void testDisplay(int scale, String inputDigit) {
        LcDisplay.Display(scale, inputDigit.toCharArray());
        System.out.println("-------------------------------------");
        Scanner scanner = new Scanner(new LcDisplay(scale, inputDigit.toCharArray()));
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
