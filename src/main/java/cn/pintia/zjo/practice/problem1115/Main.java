package cn.pintia.zjo.practice.problem1115;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 *  Correct Answer
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

/**
 * @ClassName: Main
 * @Description: zjo 1115 Digit Root
 * Attention：
 * 题目没有说明输入的positive integer有多大，所以int或者long类型可能远远不能满足其需求，由此
 * 可见设计该题目的人非常的“狡诈”，让一般的程序员在无数次提交后在WA中徘徊。
 * 从测试的角度来看就要求在阅读题目需求的同时要同时构思设计的测试用例数据非常全面，这样才能写出更加严谨
 * 和可靠（AC）的程序。
 * -----------------------------------------------------------------------------------
 * 让我想起了季怡故意卖关子来坑下属的事情，交代任务不完全或者说没头没尾(Like as Zjo 1115中描述的测试用例)，
 * 又开始忽悠下属去做事情马上要结果，总之做的好做不好都要被怒斥一通。
 * 当时GLL和ZW会看阿里云的运维界面吗？完全是foolish talk……
 * 怪不得他要在朋友圈中发《诗经·氓》
 * -----------------------------------------------------------------------------------
 * 以上完全是腹诽。
 * @Author :lei.zhu
 * @Date 2019/12/12 16:31
 * @Version 1.0
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
