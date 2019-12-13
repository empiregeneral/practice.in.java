package cn.pintia.zjo.practice.problem4105;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: zjo 4105
 * @Author :lei.zhu
 * @Date 2019/12/12 11:24
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        //Scanner sc = new Scanner(ResourceHelper.getResourceAsStream(Main.class, "TestCases_4105.txt"));
        int cases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cases; i++) {
            String originStr = sc.nextLine();
            Readable words = new AbbreviationWords(originStr);
            Scanner scanner = new Scanner(words);
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
    }
}

class AbbreviationWords implements Readable {
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
        return Arrays.binarySearch(arr, c) >= 0;
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


