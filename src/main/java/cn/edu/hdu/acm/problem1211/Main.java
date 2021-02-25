package cn.edu.hdu.acm.problem1211;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextBigInteger()) {
            BigInteger p = input.nextBigInteger();
            BigInteger q = input.nextBigInteger();
            /* public Key */
            BigInteger e = input.nextBigInteger();
            int n = input.nextInt();
            BigInteger[] cipherCodes = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                cipherCodes[i] = input.nextBigInteger();
            }
            Readable readable = new TransformToPlainText(cipherCodes, p, q, e);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
