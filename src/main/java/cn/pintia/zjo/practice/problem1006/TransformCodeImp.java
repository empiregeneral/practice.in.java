package cn.pintia.zjo.practice.problem1006;

import java.util.Arrays;

/**
 * @ClassName: TransformCipherCodeImp
 * @Description: 实现TransformCode接口， 字符串转int[]数组， int[]数组转字符串
 * @Author :lei.zhu
 * @Date 2019/11/11 17:09
 * @Version 1.0
 **/
public class TransformCodeImp implements TransformCode {
    private String text;
    private char[] toChars;
    private int n;
    private int[] codes;
    private char[] tables = "_abcdefghijklmnopqrstuvwxyz.".toCharArray();


    public TransformCodeImp(String text) {
        this.text = text;
        this.toChars = text.toCharArray();
        this.n = text.length();
    }

    public TransformCodeImp(int[] codes) {
        this.codes = codes;
        this.n = codes.length;
    }

    /**
     * @return int[]
     * @Author lei.zhu
     * @Description 将字符数组编辑为Int数组
     * @Date 11:21 2019/11/12
     * @Param [chars]
     **/
    @Override
    public int[] transformChar2Int(char[] chars) {
        if (chars == null) {
            return new int[0];
        }

        if (chars.equals(toChars)) {
            int[] tempInt = new int[n];
            for (int i = 0; i < n; i++) {
                tempInt[i] = Arrays.binarySearch(tables, toChars[i]);
            }
            return tempInt;
        } else {
            int n = chars.length;
            int[] tmpInt = new int[n];
            for (int i = 0; i < n; i++) {
                tmpInt[i] = Arrays.binarySearch(tables, chars[i]);
            }
            return tmpInt;
        }
    }

    /**
     * @return char[]
     * @Author lei.zhu
     * @Description 将Int数组编辑为字符数组char[]
     * @Date 11:24 2019/11/12
     * @Param [arr]
     **/
    @Override
    public char[] transformInt2Char(int[] arr) {
        if (arr == null) {
            return new char[0];
        }
        if (arr.equals(codes)) {
            char[] tmpChars = new char[n];
            for (int i = 0; i < n; i++) {
                tmpChars[i] = charOf(tables, arr[i]);
            }
            return tmpChars;
        } else {
            int n = arr.length;
            char[] tempChars = new char[n];
            for (int i = 0; i < n; i++) {
                tempChars[i] = charOf(tables, arr[i]);
            }
            return tempChars;
        }
    }

    private char charOf(char[] array, int index) {
        return array[index];
    }

    public String transformInt2String(int[] arr) {
        return String.valueOf(transformInt2Char(arr));
    }
}
