package cn.pintia.zjo.practice.problem2136;

import edu.princeton.cs.algs4.In;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author lei.zhu
 * @Description 查找输入integer数组的最长子序列
 * @Date 9:06 2020/4/12
 * @Param
 * @return
 **/
public class FindLongestOrderSequenceImp implements Readable, FindLongestOrderSequence {

    private int[] inputArr;
    private int[] dp;
    private int count = 1;
    private boolean ascendingOrder;

    public FindLongestOrderSequenceImp(List<Integer> myList) {
        this(myList, true);
    }

    public FindLongestOrderSequenceImp(List<Integer> myList, boolean isAscendOrder) {
        inputArr = myList.stream().mapToInt(e -> e.intValue()).toArray();
        dp = new int[myList.size()];
        this.ascendingOrder = isAscendOrder;
        if (ascendingOrder) {
            initArr(dp, 1);
        } else {
            initArr(dp, 0);
        }
    }

    private void initArr(int[] arr, int val) {
        Objects.nonNull(arr);
        Arrays.fill(arr, val);
    }

    private void startDp(boolean isAscendOrder) {
        int size = inputArr.length;
        if (isAscendOrder) {
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (inputArr[j] < inputArr[i]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                        }
                    }
                }
            }
        } else {
            for (int i = 1; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (inputArr[j] > inputArr[i]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getResult() {
        startDp(ascendingOrder);
        OptionalInt optionalInt = Arrays.stream(dp).reduce(Integer::max);
        return optionalInt.getAsInt();
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
