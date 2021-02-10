package cn.pintia.zjo.practice.problem2645;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.List;

import static edu.princeton.cs.algs4.LongestCommonSubstring.lcs;

/**
 * @author Administrator
 */
public class Solution implements Readable{
    private int count = 1;
    private String longestCommonString;
    private final int maxBitLen = 32;
    private BitSet bitSet;

    public Solution(List<String> addressList) {
        longestCommonString = addressList.stream().reduce((s, t) -> lcs(s, t)).get();
        bitSet = BitSet.valueOf(longestCommonString.getBytes(StandardCharsets.UTF_8));


    }

    private String appendTailingZeroes(String originStr, int maxBitLen) {
        int strSize = originStr.length();
        assert strSize < maxBitLen;
        int scale = (maxBitLen - strSize);

        StringBuilder sb = new StringBuilder("");
        char[] chars = new char[scale];
        for (int i = 0; i < scale; i++) {
            chars[i] = '0';
        }
        sb.append(originStr).append(chars);
        return sb.toString();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(appendTailingZeroes(longestCommonString, maxBitLen));

        return 10;
    }
}
