package cn.edu.hdu.acm.problem1047;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Integer Inquiry
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int blocks = input.nextInt();

        for (int kases = 0; kases < blocks; kases++) {
            while(input.hasNext()) {
                List<BigInteger> bigIntegers = new LinkedList<>();
                bigIntegers.add(new BigInteger(input.next()));

                for (BigInteger bigInteger : bigIntegers) {

                }
            }

            if ( kases != blocks -1) {
                System.out.println();
            }

        }







    }
}
