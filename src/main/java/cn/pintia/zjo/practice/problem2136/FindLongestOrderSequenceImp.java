package cn.pintia.zjo.practice.problem2136;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lei.zhu
 * @Description 查找输入integer数组的最长子序列
 * @Date 9:06 2020/4/12
 * @Param
 * @return
 **/
public class FindLongestOrderSequenceImp implements Readable, FindLongestOrderSequence {

    private List<Integer> inputList;
    private int size;
    private List<Integer> items;
    private int count = 1;

    public FindLongestOrderSequenceImp(List<Integer> myList) {
        this.inputList = myList;
        this.size = myList.size();
        items = new ArrayList<Integer>();
    }

    private void find() {
        for (int i = 0; i < this.size; i++) {
            int m = 0;
            for (int j = 0; j < i; j++) {
                if ((inputList.get(j) < inputList.get(i)) && m < items.get(j)) {
                    m = items.get(j);
                }
            }
            items.add(m+1);
        }
    }


    @Override
    public int getResult() {
        find();
        int maxLen = 0;
        for (Integer e: items) {
            if (e > maxLen) {
                maxLen = e;
            }
        }

        return maxLen;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(""+getResult());
        return 10;
    }
}
