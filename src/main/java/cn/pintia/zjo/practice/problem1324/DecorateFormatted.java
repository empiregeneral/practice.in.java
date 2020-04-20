package cn.pintia.zjo.practice.problem1324;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;
import java.util.Scanner;

/**
  * @Author lei.zhu
  * @Description 向unix系统的ls命令一样输出，此为装饰器模式的应用
  * @Date 22:47 2020/3/31
  * @Param
  * @return
 **/
public class DecorateFormatted extends Formatted implements FormattedListInString, Readable {
    private Scanner input;
    private int count = 1;

    public DecorateFormatted(List<String> inputList) {
        super(inputList);
        input = new Scanner(new Formatted(inputList));
    }

    @Override
    public Readable formatted() {
        return this;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        /* 修饰出现头部内容，是60个'-'组成的 */
        cb.append("------------------------------------------------------------\n");
        while (input.hasNextLine()) {
            // 修饰去除行尾的空格字符
            cb.append(input.nextLine().replaceAll("[　*| *| *|//s*]*$", ""));
            cb.append("\n");
        }

        return 10;
    }
}
