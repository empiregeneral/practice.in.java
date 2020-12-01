package cn.edu.hdu.acm.problem1629;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    Pattern pattern = Pattern.compile("\\s");

    @Test
    public  void test() {
        String input = "2H 2S 3H 3S 3C 2D 3D 6C 9C TH";
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        if (matcher.find(14)) {
            matcher.appendReplacement(sb, ",");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

}
