package think.in.java.string.regex;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class RegexUtilTest {
    @Test
    @Parameters({" |I love Canadian"})
    public void testIsMatch(String regex, String input) {
        Assert.assertTrue(RegexUtil.contains(regex, input));
    }

    @Test
    @Parameters(" |I love Canadian")
    public void testLastIndexOf(String regex, String input) {
        System.out.println(RegexUtil.indexOf(regex, input));
    }

    @Test
    @Parameters("love|I love Canadian")
    public void testExtract(String regex, String input) {
        Assert.assertEquals("love", RegexUtil.extract(regex, input));
    }

    @Test
    @Parameters(" |I love Canadian|2")
    public void testSpilt(String regex, String input, int limit) {
        String[] result = RegexUtil.split(regex, input, limit);
        for (String str: result) {
            System.out.println(str);
        }
    }



}
