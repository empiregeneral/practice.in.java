package cn.pintia.zjo.practice.test.problem1951;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Scanner;

@Epic("数论题")
@Feature("用数据和等式展现哥德巴赫猜想在1百万个正整数内是正确的")
@RunWith(JUnitParamsRunner.class)
public class Problem1951Test {

    @Test
    //@Parameters({"8,8 = 3 + 5", "20,20 = 3 + 17", "42,42 = 5 + 37"})
     @FileParameters(value = "src/test/resources/data_zjo_1951.csv", mapper = StringMapper.class)
    public void testEquationSolution(int num, String equation) throws Exception {
        int[] primes = SieveOfEratosthenes.listOfPrimes(1000000);
        int[] tmpArr = {0};
        for (int index = 0; index < primes.length; index++) {
            if (primes[index] > num) {
                tmpArr = Arrays.copyOfRange(primes, 0, index);
                break;
            }
        }
        Readable readable = new FindGoldbachEquationImp(tmpArr, num);
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            Assert.assertEquals(output.nextLine(), equation);
        }
    }
}
