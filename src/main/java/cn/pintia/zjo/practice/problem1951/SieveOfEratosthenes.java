package cn.pintia.zjo.practice.problem1951;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {
    public static int[] listOfPrimes(int n) {
        boolean[] flags = new boolean[n+1];
        int[] primes = new int[n+1];

        // Initialize flags[i] to true, primes to 0
        Arrays.fill(flags, true);
        Arrays.fill(primes, 0);

        for (int k = 2; k <= n / k; k++) {
            if (flags[k]) {
                for (int i = k; i <= n / k; i++) {
                    flags[k * i] = false;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (flags[i]) {
                primes[i] = i;
            }
        }

        int[] tmpInts = Arrays.copyOfRange(primes, 2, primes.length);
        int[] result = IntStream.of(tmpInts).filter(num -> num != 0).toArray();

        return result;
    }

    private static void printArr(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            if ( count % 10 == 0) {
                System.out.printf("%7d\n", array[i]);
            } else {
                System.out.printf("%7d", array[i]);
            }

        }
    }
}
