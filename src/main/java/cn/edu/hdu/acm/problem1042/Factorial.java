package cn.edu.hdu.acm.problem1042;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;

public class Factorial implements Readable {
    private int count = 1;
    private int n;
    final int threshold =  10000;
    String result;
    int maxCharBuffLen = 256;

    public Factorial(int n) {
        this.n = n;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        result = factorial(this.n).toString();

        if ( result.length() > maxCharBuffLen ) {
            System.out.println(result);
        } else {
            cb.append(result);
        }

        return 10;
    }

    private BigInteger factorial(int n) {
        if (n < 0 || n > this.threshold) {
            throw new RuntimeException("Not result");
        }

        if ( 0 == n ) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
