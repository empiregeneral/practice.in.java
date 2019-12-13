package cn.pintia.zjo.practice.problem1115;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @Author lei.zhu
 * @Description DigitRoot的算法实现部分
 * @Date 15:26 2019/12/13
 * @Param Value 表示数字字符串
 * @return digitRoot int类型最后的结果
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
