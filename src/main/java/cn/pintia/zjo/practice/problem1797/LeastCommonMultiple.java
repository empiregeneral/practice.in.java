package cn.pintia.zjo.practice.problem1797;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @ClassName: LeastCommonMultiple
 * @Description: zju 1797 注意连续乘法的溢出问题
 * @Author :lei.zhu
 * @Date 2019/12/16 14:43
 * @Version 1.0
 **/
public class LeastCommonMultiple {
    private int lcm;

    public LeastCommonMultiple(IntStream stream) {
        OptionalInt result = stream.reduce((o1, o2) -> (o1 / gcd(o1, o2)) * o2);
        this.lcm = result.getAsInt();
    }

    public LeastCommonMultiple(int[] array) {
        Arrays.sort(array);
        IntStream stream = Arrays.stream(array);
        OptionalInt result = stream.reduce((o1, o2) -> (o1 / gcd(o1, o2)) * o2);
        this.lcm = result.getAsInt();
    }

    public int getLcm() {
        return lcm;
    }

    private int gcd(int a, int b) {
        int r = 0;

        while (b != 0) {
            r = b;
            b = a % b;
            a = r;
        }

        return a;
    }
}
