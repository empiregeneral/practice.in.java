package cn.pintia.zjo.practice.problem2732;


import java.io.BufferedInputStream;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BitSet bits = new BitSet(100);

        for (int n = 0; n < 100; n++) {
            if ( (n -2) % 4 == 0 ) {
                bits.set(n);
            }
        }

        System.out.println(bits);

        Scanner input = new Scanner(new BufferedInputStream(System.in));

        while(input.hasNext()) {
            int n = input.nextInt();
            if (bits.get(n)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
