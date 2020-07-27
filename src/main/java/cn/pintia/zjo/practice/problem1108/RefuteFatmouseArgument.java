package cn.pintia.zjo.practice.problem1108;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Administrator
 */
public class RefuteFatmouseArgument implements Readable {
    private int count = 1;
    private List<Fatmouse> fatmouseList;
    private int[] dp;
    private Fatmouse[] fatmouses;
    private int[] path;


    public RefuteFatmouseArgument(List<Fatmouse> fatmouseList) {
        this.fatmouseList = fatmouseList;
        dp = new int[fatmouseList.size()];
        path = new int[fatmouseList.size()];
        fatmouses = new Fatmouse[fatmouseList.size()];
        initArr(dp, 1);
        initArr(path, 0);
        fatmouses = listToArray(this.fatmouseList);
    }

    private void initArr(int[] arr, int val) {
        Objects.nonNull(arr);
        Arrays.fill(arr, val);
    }

    private Fatmouse[] listToArray(List<Fatmouse> list) {
         return list.toArray(fatmouses);
    }

    private void startDp() {
        int size = fatmouseList.size();
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if ((fatmouses[i].getWeight() > fatmouses[j].getWeight()) && (fatmouses[i].getSpeed() < fatmouses[j].getSpeed())) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                    // 逐个记录，推导前的位置
                    path[i] = j;
                }
            }
        }
    }

    private void recursionOutput(int[] path, int pos, CharBuffer cb) {
        if (pos == 0) {
            return;
        }
        recursionOutput(path, path[pos], cb);
        cb.append(fatmouses[pos].getNo() + "\n");

    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        startDp();
        int longestSubLen = Arrays.stream(dp).reduce(Integer::max).getAsInt();
        cb.append("" + longestSubLen);
        cb.append("\n");

        int ans = dp[0];

        int pos = 0;
        for (int i = 0; i < dp.length; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
                pos = i;
            }
        }

        recursionOutput(path, pos, cb);

        return 10;
    }

}
