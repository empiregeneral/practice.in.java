package cn.edu.hdu.acm.problem1211;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            int p = input.nextInt();
            int q = input.nextInt();
            /* public Key */
            int e = input.nextInt();
            int n = input.nextInt();
            Integer[] cipherCodes = new Integer[n];
            for (int i = 0; i < n; i++) {
                cipherCodes[i] = input.nextInt();
            }
            Readable readable = new TransformToPlainText(cipherCodes, p, q, e);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }

    }
}
