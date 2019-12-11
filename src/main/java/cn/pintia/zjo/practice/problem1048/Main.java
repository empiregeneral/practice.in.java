package cn.pintia.zjo.practice.problem1048;

import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * @ClassName: Main
 * @Description: zjo 1048 Financial Management
 * 面向对象编程
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

class FinancialManagement implements Readable{
    private double mean;
    private int count = 1;

    public FinancialManagement(DoubleStream stream) {
        double result = stream.reduce(0.0, (sum, d1) -> (sum + d1));
        mean = result / 12;
    }

    public double getMean() {
        return mean;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(String.format("$%.02f", new Object[]{this.getMean()}));
        cb.append("\n");

        return 10;
    }
}