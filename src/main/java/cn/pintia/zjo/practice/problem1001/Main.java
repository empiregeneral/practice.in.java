package cn.pintia.zjo.practice.problem1001;

import java.io.*;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: zjo 1001
 * Calculate a + b
 * @Author :lei.zhu
 * @Date 2019/12/12 15:29
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
        }
        out.flush();
    }
}
