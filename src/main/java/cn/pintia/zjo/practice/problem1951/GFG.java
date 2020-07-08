package cn.pintia.zjo.practice.problem1951;

// Java program to implement Goldbach's conjecture

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class GFG {

    private static final int MAX = 1000000;

    // Array to store all prime less
    // than and equal to 10^7
    private static ArrayList<Integer> primes = new ArrayList<Integer>();

    // Utility function for Sieve of Sundaram
    private static void sieveSundaram() {
        // In general Sieve of Sundaram, produces
        // primes smaller than (2*x + 2) for
        // a number given number x. Since
        // we want primes smaller than MAX,
        // we reduce MAX to half This array is
        // used to separate numbers of the form
        // i + j + 2*i*j from others where 1 <= i <= j
        boolean[] marked = new boolean[MAX / 2 + 100];

        // Main logic of Sundaram. Mark all numbers which
        // do not generate prime number by doing 2*i+1
        for (int i = 1; i <= (Math.sqrt(MAX) - 1) / 2; i++) {
            for (int j = (i * (i + 1)) << 1; j <= MAX / 2; j = j + 2 * i + 1) {
                marked[j] = true;
            }
        }


        // Since 2 is a prime number
        primes.add(2);

        // Print other primes. Remaining primes are of the
        // form 2*i + 1 such that marked[i] is false.
        for (int i = 1; i <= MAX / 2; i++) {
            if (marked[i] == false) {
                primes.add(2 * i + 1);
            }
        }

    }

    // Function to perform Goldbach's conjecture
    private static void findPrimes(int n) {
        // Return if number is not even or less than 3
        if (n <= 2 || n % 2 != 0) {
            System.out.println("Invalid Input ");
            return;
        }

        // Check only upto half of number
        for (int i = 0; primes.get(i) <= n / 2; i++) {
            // find difference by subtracting
            // current prime from n
            int diff = n - primes.get(i);

            // Search if the difference is
            // also a prime number
            if (primes.contains(diff)) {
                // Express as a sum of primes
                System.out.println(n + " = " + primes.get(i) +
                        " + " + diff);
                return;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Finding all prime numbers before limit
        sieveSundaram();
//        BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));
//        System.setIn(in);
        byte[] bufferByte = readFileByNio(args[0]);
        Scanner scanner = new Scanner(new ByteArrayInputStream(bufferByte), "utf-8").useDelimiter("\r\n");

        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if ( n == 0 ) {
                break;
            }
            // Express number as a sum of two primes
            findPrimes(n);
        }
        scanner.close();
    }

    private static byte[] readFileByNio(String path) {
        long fileLength = 0;
        final int BUFFER_SIZE = 0x50000;// 0.5M的缓冲
        File file = new File(path);
        fileLength = file.length();
        byte[] dst = new byte[BUFFER_SIZE];
        try {
            MappedByteBuffer inputBuffer = new RandomAccessFile(file, "r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, fileLength);// 读取大文件

            for (int offset = 0; offset < fileLength; offset+=BUFFER_SIZE) {
                if (fileLength - offset >= BUFFER_SIZE) {
                    for (int i = 0; i < BUFFER_SIZE; i++) {
                        dst[i] = inputBuffer.get(offset + i);
                    }
                } else {
                    for (int i = 0; i < fileLength - offset; i++) {
                        dst[i] = inputBuffer.get(offset + i);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dst;
    }
}


