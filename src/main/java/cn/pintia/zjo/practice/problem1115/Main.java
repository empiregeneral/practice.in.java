package cn.pintia.zjo.practice.problem1115;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: zjo 1115 Digit Root
 * 题目没有说明输入的positive integer有多大，所以int或者long类型可能远远不能满足其需求，所以
 * 设计该题目的人非常的“狡诈”，让一般的程序员完全在WA中打转。
 * 从测试的角度来看就要求在阅读题目需求的同事设计测试用例设计考虑的非常全面，
 * 才能写出更加严谨和未出WA的代码。
 * -----------------------------------------------------------------------------------
 * 让我想起了季怡故意卖关子后面来坑下属的事情，交代任务不完全就像Zjo 1115中描写的测试用例一样，
 * 就开始忽悠下属去做事情，做的好做不好都要怒斥一遍。
 * 当时Guolinlin和Zhengwei会看阿里云的运维界面吗？完全是谎话连篇……
 * @Author :lei.zhu
 * @Date 2019/12/12 16:31
 * @Version 1.0
 **/

/**
 * @Author lei.zhu
 * @Description Correct Answer
 * #include<stdio.h>
 * #include<string.h>
 * #include<math.h>
 * <p>
 * int main()
 * {
 * int i,n,tmp;
 * char a[1003];
 * while (scanf("%s",&a)&&a[0]!='0')
 * {
 * n=0;
 * for (i=0;i<strlen(a); i++)
 * {
 * n+=a[i]-48;
 * }
 * printf("%d\n",(n-1)%9+1);
 * }
 * return 0;
 * }
 * @Date 18:15 2019/12/12
 * @Param
 * @return
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (value.charAt(0) == '0') {
                break;
            } else {
                Readable readable = new DigitRoot(value);
                Scanner out = new Scanner(readable);
                System.out.println(out.next());
            }

        }
    }
}

class DigitRoot implements Readable {
    private char[] chars;
    private int digitRoot = 0;
    private int count = 1;

    public DigitRoot(String value) {
        this.chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            digitRoot = 1 + (digit + digitRoot - 1) % 9;
        }
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append("" + digitRoot);
        cb.append("");
        return 10;
    }
}
