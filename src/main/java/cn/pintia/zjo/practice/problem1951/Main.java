package cn.pintia.zjo.practice.problem1951;

import java.util.BitSet;
import java.util.Scanner;

public class Main {

    private static final int size = 1000000;
    public static BitSet bitSet = new BitSet(size+100);

    public static void main(String[] args) {
        compute_prime_bitset();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            solve_case(n);
        }

    }

    private static void compute_prime_bitset() {

        for (int i = 2; i < size;i++) {
            bitSet.set(i);
        }

        for (int i = 2; i <= (int)Math.sqrt(size); ) { /** i * i < n 故缩小平方根为判断条件*/
            for (int j = i + i; j <= 1000000; j += i){
                bitSet.clear(j);  /* delete all multiples of i */
            }

            for (i++; !bitSet.get(i); i++) { /* find next prime */

            }
        }

    }

    private static void solve_case(int n) {
        for (int i = 3, j = n - 3; i <= j; i++, j--) {
            if (bitSet.get(i) && bitSet.get(j)) {
                System.out.printf("%d = %d + %d\n", n, i, j);
                break;
            }
        }
    }
}
