package cn.pintia.zjo.practice.problem1160;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int blocks = input.nextInt();

        for (int kases = 0; kases < blocks; kases++) {
            for (int times = 1; input.hasNext(); ++times) {
                int p = input.nextInt();
                int e = input.nextInt();
                int i = input.nextInt();
                int d = input.nextInt();
                if (p == -1 && e == -1 && i == -1 && d == -1) {
                    break;
                }
                int lcm = 21252;
                int n=(5544*p+14421*e+1288*i-d+21252)%lcm;

                if (n == 0) {
                    n += lcm;
                }

                System.out.println("Case " +times + ": the next triple peak occurs in " + n + " days.");
            }


            if ( kases != blocks-1) {
                System.out.println();
            }
        }

    }
}
