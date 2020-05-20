package cn.pintia.zjo.practice.problem1324;

import java.io.IOException;
import java.nio.CharBuffer;
import java.text.Collator;
import java.util.*;

/**
  * @Author lei.zhu
  * @Description 格式化输出打印结果
  * @Date 1:05 2020/4/4
  * @Param 
  * @return 
 **/
public class Formatted implements FormattedListInString, Readable {
    private List<String> outputList =  new ArrayList<>();
    private List<String> inputList;
    private int paddedScale;
    private int count = 1;
    private final int DEFAULT_ROWS = 10;
    private final int DEFAULT_COLUMNS = 1;
    private final int SCREEN_WIDTH = 60;
    private int ROWS = DEFAULT_ROWS;
    private int COLUMNS = DEFAULT_COLUMNS;

    public Formatted(List<String> inputList) {
        this.inputList = inputList;
        int n = inputList.size();
        this.paddedScale = findLongestStrLength(inputList) + 2;
        Collections.sort(this.inputList, Collator.getInstance());
        formatedStrList(this.inputList, this.paddedScale);
        if (this.paddedScale > SCREEN_WIDTH) {
            COLUMNS = 1;
        } else {
            // 怎么推算的？
            COLUMNS = SCREEN_WIDTH / this.paddedScale;
        }
        // 怎么推算的？
        ROWS = ((n - 1) / COLUMNS ) + 1;
    }

    private int findLongestStrLength(List<String> inputList) {
        Optional<Integer> maxLenInStrList = inputList.stream().map(w -> w.length()).max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return maxLenInStrList.get();
    }

    private void formatedStrList(List<String> list, int paddedScale) {
        Iterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String tmpStr = iterator.next();
            int scale = paddedScale - tmpStr.length();
            String formattedStr = paddedCharSequence(tmpStr, scale);
            outputList.add(formattedStr);
        }
    }

    @Override
    public String toString() {
        return outputList.toString();
    }


    private String paddedCharSequence(CharSequence seq, int scale) {
        StringBuilder sb = new StringBuilder("");
        char[] tmpChars = new char[scale];
        for (int i = 0; i < scale; i++) {
            tmpChars[i] = ' ';
        }
        sb.append(seq).append(tmpChars);
        return sb.toString();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        /* 将一维列表作为二维矩阵打印出来，要注意的是越界的问题 */
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                int index = column * ROWS + row;
                if (index >= outputList.size()) {
                    break;
                }
                cb.append(outputList.get(index));
            }
            cb.append("\n");
        }
        cb.append("");

        return 0;
    }

    @Override
    public Readable formatted() {
        return this;
    }
}