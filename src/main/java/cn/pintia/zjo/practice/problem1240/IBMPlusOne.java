package cn.pintia.zjo.practice.problem1240;

import java.io.IOException;
import java.nio.CharBuffer;

/**
  * @Author lei.zhu
  * @Description 可以算的上最简单的字符串处理题目，熟练的人5分钟内就可以编写完成
  * @Date 17:24 2020/3/29
  * @Param
  * @return
 **/
public class IBMPlusOne implements Readable {
    private int count = 1;
    private final int PLUSONE = 1;
    private CharSequence input;

    public IBMPlusOne(CharSequence charSequence) {
        this.input = charSequence;
    }

    private char getNumbericeValue(char ch, int offset) {
        int ret = (ch + offset);
        return (char) ((ret > 90) ? ret - 26 : ret);
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        for (int i = 0; i < input.length(); i++) {
            cb.append("" +getNumbericeValue(input.charAt(i), PLUSONE));
        }
        cb.append("");

        return 10;
    }
}
