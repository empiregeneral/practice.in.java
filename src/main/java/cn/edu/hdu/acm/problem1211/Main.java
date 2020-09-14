package cn.edu.hdu.acm.problem1211;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            BigInteger p = intToBigInteger(input.nextInt());
            BigInteger q = intToBigInteger(input.nextInt());
            /* public Key */
            BigInteger e = intToBigInteger(input.nextInt());
            int n = input.nextInt();
            BigInteger[] cipherCodes = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                cipherCodes[i] = intToBigInteger(input.nextInt());
            }
            Readable readable = new TransformToPlainText(cipherCodes, p, q, e);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }

    private static BigInteger intToBigInteger(int item) {
        return new BigInteger(new Integer(item).toString());
    }
}
