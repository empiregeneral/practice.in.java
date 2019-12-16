package cn.pintia.zjo.practice.problem1526;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.CharBuffer;

/**
 * @ClassName: BigNumber
 * @Description: zju 1526
 * 实际上是double类型的精度计算问题,求1-n个lg累加和
 * @Author :lei.zhu
 * @Date 2019/12/13 17:19
 * @Version 1.0
 **/
public class BigNumber implements Readable {
    private int n;
    private int count = 1;
    private final double log10_e = Math.log10(Math.E);
    private final double log_2_pi = Math.log10(2 * Math.PI) / 2.0;
    private double E = Math.E;

    public BigNumber(int num) {
        this.n = num;
    }

    private double stirlingFormula() {
        double a = n;
        double res = Math.ceil(log_2_pi + (a + 0.5) * Math.log10(a) -  a * log10_e);
        return res;
    }

    private CharSequence digitInFactorialNum() {
        Double d = 0.0;
        for (int i = 1; i<=n; i++) {
            d += Math.log10(i);
        }
        d = Math.ceil(d);
        BigDecimal bigDecimal= BigDecimal.valueOf(d).setScale(0);
        return bigDecimal.toPlainString();
    }


    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        if (n == 1) {
            cb.append('1');
        } else {
            CharSequence charSequence = BigDecimal.valueOf(stirlingFormula()).setScale(0).toPlainString();
            cb.append(charSequence);
        }
        cb.append("");

        return 10;
    }
}
