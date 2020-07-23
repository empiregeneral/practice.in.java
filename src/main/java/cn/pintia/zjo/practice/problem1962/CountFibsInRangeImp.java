package cn.pintia.zjo.practice.problem1962;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;

public class CountFibsInRangeImp implements CountFibsInRange, Readable{
    private int count = 1;
    private BigInteger lower;
    private BigInteger upper;
    private BigInteger[] fibs;

    public CountFibsInRangeImp(BigInteger lower, BigInteger upper, BigInteger[] fibs) {
        this.lower = lower;
        this.upper = upper;
        this.fibs = fibs;
    }

    @Override
    public int count() {
        // search lower and upper bounds
        int ilower = 0, iupper = 0;
        while(lower.compareTo(fibs[ilower]) > 0) {
            ilower++;
        }

        while(upper.compareTo(fibs[iupper]) >= 0) {
            iupper++;
        }
        return (iupper - ilower);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append("" +count());
        return 10;
    }
}
