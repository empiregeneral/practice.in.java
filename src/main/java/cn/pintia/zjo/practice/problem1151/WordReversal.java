package cn.pintia.zjo.practice.problem1151;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Stack;

public class WordReversal implements Readable {
    private int count = 1;
    private Stack<Character> stack = new Stack<>();
    private char[] chars;


    public WordReversal(String wordsInLine) {
        this.chars = wordsInLine.toCharArray();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        for (Character ch : chars) {
            if (!isSpace(ch)) {
                stack.push(ch);
            } else {
                while (!stack.empty()) {
                    cb.append(stack.pop());
                }
                cb.append(' ');
            }
        }

        while (!stack.empty()) {
            cb.append(stack.pop());
        }

        cb.append("");

        return 10;
    }

    private boolean isSpace(Character ch) {
        return (ch == ' ') ? true : false;
    }
}
