package cn.pintia.zjo.practice.problem1526;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;

/**
 * @ClassName: BigNumber
 * @Description: zju 1526
 * 实际上是double类型的精度计算问题,求1-n个lg累加和
 * @Author :lei.zhu
 * @Date 2019/12/13 17:19
 * @Version 1.0
 **/
public class BigNumber implements Readable {
    private Integer n;
    private int count = 1;

    public BigNumber(int num) {
        this.n = num;
    }

    private CharSequence digitInFactorialNum() {
        Double d = 0.0;
        for (int i = 1; i<=n; i++) {
            d += Math.log10(i);
        }
        BigDecimal bigDecimal= new BigDecimal(Math.ceil(d));
        return bigDecimal.toString();
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(digitInFactorialNum());

        return 10;
    }
}
