package cn.pintia.zjo.practice.problem1962;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int scaleInFibs = 512;
        BigInteger[] fibs = FibonacciStrategy.TWO_STRATEGY.getFibTable(scaleInFibs);
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            BigInteger lower = new BigInteger(scanner.next());
            BigInteger upper = new BigInteger(scanner.next());
            if (upper.signum() == 0) {
                break;
            }
            Scanner output = new Scanner(new CountFibsInRangeImp(lower, upper, fibs));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
