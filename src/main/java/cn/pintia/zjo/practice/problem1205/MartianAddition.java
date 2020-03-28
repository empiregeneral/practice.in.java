package cn.pintia.zjo.practice.problem1205;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

/**
 * @ClassName: CalcMartianAddtion
 * @Description: 计算20进制的字符串加法
 * @Author :lei.zhu
 * @Date 2019/12/16 14:08
 * @Version 1.0
 **/
public class MartianAddition implements Readable, Comparator<CharSequence> {
    private CharSequence firstNum;
    private CharSequence secondNum;
    private Stack<Character> stack;
    private int carry = 0;
    private char[] martianAlphabets = "0123456789abcdefghij".toCharArray();
    private int size = 0;
    private int count = 1;

    public MartianAddition(CharSequence a, CharSequence b) {
        int result = compare(a, b);
        int scale;
        stack = new Stack<>();
        if (result >= 0) {
            scale = result;
            firstNum = a ;
            secondNum = coverCharSequence(b, scale);
        } else {
            scale = result;
            firstNum = coverCharSequence(a, Math.abs(scale));
            secondNum = b;
        }
        size = firstNum.length();
    }

    private int getNumInChars(char c) {
        return Arrays.binarySearch(martianAlphabets, c);
    }

    private String coverCharSequence(CharSequence seq, int scale) {
        StringBuilder sb = new StringBuilder("");
        char[] tmpChars = new char[scale];
        for (int i = 0; i < scale; i++) {
            tmpChars[i] = '0';
        }
        sb.append(tmpChars).append(seq);
        return sb.toString();
    }

    private void getResult() {
            if (size == 0) {
                return;
            }
            for (int index = this.size - 1; index >= 0; index--) {
                int a = getNumInChars(firstNum.charAt(index));
                int b = getNumInChars(secondNum.charAt(index));
                int c = a + b + carry;
                char ch;
                if (c > 19) {
                    carry = 1;
                    ch = martianAlphabets[c - 20];
                } else {
                    carry = 0;
                    ch = martianAlphabets[c];
                }
                stack.push(ch);
            }
            if (carry > 0) {
                stack.push('1');
            }
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        getResult();

        while(!stack.isEmpty()) {
            cb.append(stack.pop());
        }
        cb.append("");


        return 10;
    }

    @Override
    public int compare(CharSequence o1, CharSequence o2) {
        return o1.length() - o2.length();
    }
}
