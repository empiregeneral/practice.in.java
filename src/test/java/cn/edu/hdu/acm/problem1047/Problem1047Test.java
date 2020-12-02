package cn.edu.hdu.acm.problem1047;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1047Test {
    @Test
    @Parameters("123456789012345678901234567890 123456789012345678901234567890 123456789012345678901234567890,370370367037037036703703703670")
    public void testIntegerInquiry(String input, String expect) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        List<BigInteger> bigIntegerList = new ArrayList<>();
        while(scanner.hasNext()) {
            bigIntegerList.add(new BigInteger(scanner.next()));
        }

        Scanner output = new Scanner(new IntegerInquiry(bigIntegerList));
        for (;output.hasNext();) {
            Assert.assertEquals(output.next(), expect);
        }
    }

}
