package cn.edu.hdu.acm.problem1047;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.List;

/**
 * @author Administrator
 */
public class IntegerInquiry implements Readable{
    private int count = 1;
    private String result;

    public IntegerInquiry(List<BigInteger> bigIntegerList) {
        BigInteger bigInteger = bigIntegerList.stream().reduce(BigInteger::add).get();
        this.result = bigInteger.toString();
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(this.result);
        return 10;
    }
}
