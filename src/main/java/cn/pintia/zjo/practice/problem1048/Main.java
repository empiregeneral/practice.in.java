package cn.pintia.zjo.practice.problem1048;


import java.io.*;

import java.util.Scanner;


/**
 * @ClassName: Main
 * @Description: zjo 1048 Financial Management
 * 要求是面向对象编程
 * @Author :lei.zhu
 * @Date 2019/12/11 16:37
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        final int totalMonthly = 12;
        Bag<Double> bag = new Bag();

        for (int i = 0; i < totalMonthly; i++) {
            bag.add(scanner.nextDouble());
        }

        Readable readable = new FinancialManagement(bag);
        Scanner output = new Scanner(readable);
        while (output.hasNext()) {
            System.out.println(output.next());
        }
    }
}

