package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.ShowHandInDeck;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1111Test {

    @Test
    @Parameters({"5C 5D 2C 2D AS,2S 2H 3C 3D AD,Black wins.","AH KH QH JH 3C,2S 2H 2C 3H TS,White wins."})
    public void testJudgement(String blackHands, String whiteHands, String result) {
        Readable readable = new ShowHandInDeck(blackHands, whiteHands);
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), result);
        }
    }
}
