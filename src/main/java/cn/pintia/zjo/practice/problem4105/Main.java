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

