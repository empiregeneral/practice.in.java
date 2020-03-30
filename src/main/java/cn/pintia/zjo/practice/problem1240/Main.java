package cn.pintia.zjo.practice.problem1240;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int cases = scanner.nextInt();

        for (int testcase = 1; testcase <= cases; testcase++) {
            Scanner out = new Scanner(new IBMPlusOne(scanner.next()));
            System.out.println("String #" + testcase);
            System.out.println(out.next());
            System.out.println();
        }
    }
}
