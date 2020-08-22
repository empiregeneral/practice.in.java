package cn.pintia.zjo.practice.problem1962;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int scaleInFibs = 512;
        BigInteger[] fibs = createTable(scaleInFibs);
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            BigInteger iLower = new BigInteger(scanner.next());
            BigInteger iUpper = new BigInteger(scanner.next());
            if (iUpper.signum() == 0) {
                break;
            }
            System.out.println(countFibsInRange(fibs, iLower, iUpper));
        }
    }

    public static int countFibsInRange(BigInteger[] fibs, BigInteger iLower, BigInteger iUpper) {
        int lower = 0;
        int upper = 0;

        for (int i = 0; i < fibs.length; i++) {
            if (iLower.compareTo(fibs[i]) > 0) {
                lower++;
            }

            if (iUpper.compareTo(fibs[i]) >= 0) {
                upper++;
            }
        }

        return (upper - lower);
    }

    public static BigInteger[] createTable(int scale) {
        BigInteger[] bigIntegers = new BigInteger[scale];
        bigIntegers[0] = new BigInteger("1");
        bigIntegers[1] = new BigInteger("2");

        for (int i = 2; i < scale; i++) {
            bigIntegers[i] = bigIntegers[i - 1].add(bigIntegers[i - 2]);
        }

        return bigIntegers;
    }
}
