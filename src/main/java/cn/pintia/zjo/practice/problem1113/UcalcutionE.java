package cn.pintia.zjo.practice.problem1113;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: UCalcutionE
 * @Description: zju 1113 无输入只有输出格式的要求
 * @Author :lei.zhu
 * @Date 2019/12/17 15:52
 * @Version 1.0
 **/
public class UcalcutionE implements Readable {

    private int count = 1;
    /** Avoid use Pattern.compile in method body. */
    private Pattern pattern = Pattern.compile("\\.0+$");

    private final int TOTAL = 9;

    @Override
    public int read(CharBuffer cb) throws IOException {
        if ( count-- == 0) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("n e\n");
        sb.append("- -----------\n");
        double sum = 0.0;
        for ( int i = 0; i <=TOTAL; i++) {
            sum += 1.0 / factor(i);

            if ( i < 3) {
                String input = String.format("%d %.1f\n", i, sum);
                Matcher matcher = pattern.matcher(input);
                String replace = "";
                input = matcher.replaceAll(replace);
                sb.append(input);
            } else {
                sb.append(String.format("%d %.9f\n", i, sum));
            }
        }

        cb.append(sb.toString());

        return 10;
    }

    private int factor(int n) {
        int tmp = 1;
        for ( int i = 1; i < n; i++) {
            tmp += tmp * i;
        }
        return tmp;
    }
}
