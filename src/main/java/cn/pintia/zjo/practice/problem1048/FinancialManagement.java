package cn.pintia.zjo.practice.problem1048;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.CharBuffer;
import java.util.stream.DoubleStream;

/**
 * @ClassName: FinancialManagement
 * @Description: zjo 1048 可说是最简单的题目之一了，没有任何难度
 * @Author :lei.zhu
 * @Date 2019/12/17 15:02
 * @Version 1.0
 **/
public class FinancialManagement implements Readable{
    private double mean;
    private int count = 1;

    public FinancialManagement(DoubleStream stream) {
        double result = stream.reduce(0.0, (sum, d1) -> (sum + d1));
        mean =  result / 12;
    }

    public double getMean() {
        return mean;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append("$"+ String.format("%.2f", getMean()));
        cb.append("\n");

        return 10;
    }

}
