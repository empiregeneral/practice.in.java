package cn.pintia.zjo.practice.problem1240;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
  * @Author lei.zhu
  * @Description 请用装饰器模式修饰Scanner out的输出
  * @Date 22:55 2020/3/30
  * @Param
  * @return
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int cases = scanner.nextInt();

        for (int testcase = 1; testcase <= cases; testcase++) {
            Readable readable = new IBMPlusOne(scanner.next(), 1);
            Scanner out = new Scanner(readable);
            System.out.println("String #" + testcase);
            System.out.println(out.next());
            System.out.println();
        }
    }
}

