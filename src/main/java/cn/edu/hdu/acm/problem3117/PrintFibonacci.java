package cn.edu.hdu.acm.problem3117;

import java.io.IOException;
import java.nio.CharBuffer;

public class PrintFibonacci implements Readable {
    private int count = 1;
    private int n;
    private final int threshold = 40;

    public PrintFibonacci(int n) {
        this.n = n;
    }

    private int calFibNumberHead(int n) {
        double log = (-0.5*Math.log10(5) + (double)n*Math.log10(((1+Math.sqrt(5))*1.0)/2));
        double tmp = (log - (int)log + 3);
        return (int)Math.pow(10, tmp);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        if (n < threshold) {   
            cb.append(""+GoldenRatioForFib.fib(n));
        } else {
            CharSequence Header = "" + calFibNumberHead(n);
            CharSequence body = "...";
            CharSequence tail = MatrixPower.tailForFibNum(n);
            StringBuilder sb = new StringBuilder("");
            sb.append(Header).append(body).append(tail);
            cb.append(sb.toString());
        }

        return 10;
    }
}
