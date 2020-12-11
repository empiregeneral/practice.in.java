package cn.edu.hdu.acm.problem1047;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.*;

/**
 * Integer Inquiry
 * @Author lei.zhu
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int blocks = Integer.parseInt(input.next());

        for (int kases = 0; kases < blocks; kases++) {
            List<BigInteger> bigIntegers = new ArrayList<>();
            while(input.hasNext()) {
                String bigInteger = input.next();
                if (new BigInteger("0").equals(new BigInteger(bigInteger))) {
                    break;
                }
                bigIntegers.add(new BigInteger(bigInteger));
            }

            Readable readable = new IntegerInquiry(bigIntegers);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }

            if ( kases != blocks -1) {
                System.out.println();
            }
        }
    }
}
