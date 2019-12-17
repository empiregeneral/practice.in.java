package cn.pintia.zjo.practice.problem1048;

import java.io.*;
import java.math.BigDecimal;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

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
        double[] balanceInMonthly = new double[12];

        for (int i = 0; i < 12; i++) {
            balanceInMonthly[i] = scanner.nextDouble();
        }

        Readable readable = new FinancialManagement(Arrays.stream(balanceInMonthly));
        Scanner output = new Scanner(readable);
        while (output.hasNext()) {
            System.out.println(output.next());
        }
    }
}

