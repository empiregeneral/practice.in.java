package cn.pintia.zjo.practice.problem1951;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Administrator
 */
public class Eratosthenes {
    public static int[] sieve(int n) {
        int[] primes = new int[n + 1];
        Arrays.fill(primes, 0);
        BitSet b = new BitSet(n+1);
        int i;
        for(i = 2; i <= n; i++) {
            b.set(i);
        }
        i = 2;
        while(i <= n / i ) {
            if(b.get(i)) {
                int k = i * 2;
                while(k <= n){
                    b.clear(k);
                    k += i;
                }
                primes[i] = i;
            }
            i++;
        }
        while(i <= n){
            if(b.get(i)) {
                primes[i] = i;
            }
            i++;
        }

        int[] result = IntStream.of(primes).filter(num -> num != 0).toArray();

        return result;
    }

    public static void main(String[] args) {
        int[] primes = Eratosthenes.sieve(2020091413);
        System.out.println("How many primes: " + primes.length);
        System.out.println("p: " +primes[new Random().nextInt(primes.length)]);
        System.out.println("q: " +primes[new Random().nextInt(primes.length)]);
        int d = primes[new Random().nextInt(primes.length)];
        System.out.print("d: " + d);
    }
}
