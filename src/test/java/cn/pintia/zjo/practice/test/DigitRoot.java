package cn.pintia.zjo.practice.test;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @ClassName: DigitRoot
 * @Description:
 * @Author :lei.zhu
 * @Date 2019/12/13 14:17
 * @Version 1.0
 **/
public class DigitRoot implements Readable {
    private char[] chars;
    private int digitRoot = 0;
    private int count = 1;

    public DigitRoot(String value) {
        this.chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            digitRoot = 1 + (digit + digitRoot - 1) % 9;
        }
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append("" + digitRoot);
        cb.append("");
        return 10;
    }
}
