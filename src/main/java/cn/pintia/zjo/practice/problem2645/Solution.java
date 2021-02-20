package cn.pintia.zjo.practice.problem2645;

import edu.princeton.cs.algs4.LongestCommonSubstring;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;


/**
 * @author Administrator
 */
public class Solution implements Readable {
    private int count = 1;
    private String longestCommonString;
    private String maskString;
    private final int maxBitLen = 32;

    public Solution(List<String> addressList) {
        longestCommonString = addressList.stream().reduce((s, t) -> Strategy.DynamicPlanning.lcs(s, t)).get();
        int maskLen = longestCommonString.length();
        maskString = appendTailingZeroes(createMask(maskLen), maxBitLen);
    }

    private String createMask(int maskLen) {
        StringBuilder sb = new StringBuilder("");
        char[] chars = new char[maskLen];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '1';
        }

        return sb.append(chars).toString();
    }

    private String appendTailingZeroes(String origin, int maxBitLen) {
        int strSize = origin.length();
        assert strSize < maxBitLen;
        int scale = (maxBitLen - strSize);

        StringBuilder sb = new StringBuilder("");
        char[] chars = new char[scale];
        for (int i = 0; i < scale; i++) {
            chars[i] = '0';
        }
        sb.append(origin).append(chars);
        return sb.toString();
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(BinaryStrToIpAddress.valueOf(appendTailingZeroes(longestCommonString, maxBitLen)));
        cb.append("\n");
        cb.append(BinaryStrToIpAddress.valueOf(maskString));

        return 10;
    }
}

enum Strategy {

    DynamicPlanning() {
        @Override
        public String lcs(String source, String target) {
            char[] a = source.toCharArray();
            char[] b = target.toCharArray();
            int[][] result = new int[a.length + 1][b.length + 1];
            int max = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (a[i] == b[j]) {
                        result[i + 1][j + 1] = result[i][j] + 1;
                        max = Math.max(max, result[i + 1][j + 1]);
                    }
                }
            }
            return max == 0 ? "" :source.substring(0, max);
        }
    },

    SuffixArrayX() {
      @Override
      public String lcs(String source, String target) {
          return LongestCommonSubstring.lcs(source, target);
      }
    };


    protected abstract String lcs(String source, String target);
    }
