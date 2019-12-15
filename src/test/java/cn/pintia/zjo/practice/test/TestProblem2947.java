package cn.pintia.zjo.practice.test;

import cn.pintia.zjo.practice.problem2947.CheckAbbreviation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class TestProblem2947 {

    @Parameters({"Super Harddisc Drive Cooler,Spade Heart Diamond Club,SAME",
                 "Shen Guang Hao,Shuai Ge Hao,SAME",
                 "Cai Piao Ge,C P C S,DIFFERENT",
                 "C C C P,P P P C,DIFFERENT"})
    @Test
    public void testCheckAbbreviation(String firstWords, String secondWords, String expect) {
        Readable readable = new CheckAbbreviation(firstWords, secondWords);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            Assert.assertEquals(scanner.next(), expect);
        }
    }
}
