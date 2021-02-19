package cn.pintia.zjo.practice.problem2645;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;


/**
 * @author Administrator
 */
public class Solution implements Readable{
    private int count = 1;
    private String longestCommonString;
    private String maskString;
    private final int maxBitLen = 32;

    public Solution(List<String> addressList) {
        longestCommonString = addressList.stream().reduce((s, t) -> LongestCommonSubstring.lcs(s, t)).get();
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
