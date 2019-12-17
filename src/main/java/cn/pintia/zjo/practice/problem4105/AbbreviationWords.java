package cn.pintia.zjo.practice.problem4105;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * @ClassName: AbbreviationWords1
 * @Description: TODO
 * @Author :lei.zhu
 * @Date 2019/12/17 13:45
 * @Version 1.0
 **/
public class AbbreviationWords implements Readable {
    private char[] vowels = "aeiouy".toCharArray();
    private String originWords;
    private char firstChar;
    private char[] word2charArr;
    private int count = 1;

    public AbbreviationWords(String originWords) {
        this.originWords = originWords;
        this.firstChar = originWords.charAt(0);
        this.word2charArr = originWords.substring(1).toCharArray();
    }

    /**
     * @Author lei.zhu
     * @Description 使用二分法查找char数组是否存在char，注意特殊情况'a'
     * @Date 11:34 2019/12/12
     * @Param [arr, c]
     * @return boolean
     **/
    private boolean contains(char[] arr, char c) {
        return Arrays.binarySearch(arr, c) >= 0 ? true : false;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count <0 ) {
            return -1;
        }

        cb.append(firstChar);

        for (char ch : word2charArr) {
            if (!contains(vowels, ch)) {
                cb.append(ch);
            }
        }
        cb.append("");

        return 10;
    }
}


