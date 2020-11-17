package cn.pintia.zjo.practice.problem3609;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 * @ClassName: ModuleInverse
 * @Description: 通过欧几里得扩展算法求解逆元，要求最终的结果为正整数
 * @Author :lei.zhu
 * @Date 2019/12/17 17:08
 * @Version 1.0
 **/
public class ModuleInverse implements Readable {
    private static final class GcdExtend {
        public int x;
        public int y;
        public int gcd;
    }

    public static int gcd(int a, int b) {
        int r = 0;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            r = b;
            b = a % b;
            a = r;
        }

        return a;
    }

    private int a;
    private int m;
    public GcdExtend gcdExtend;
    private int count = 1;

    public ModuleInverse(int a, int m) {
        while(a > m) {
            a -= m;
        }

        this.a = a;
        this.m = m;

        gcdExtend = ExtendedEuclidCalc(this.a, this.m);
    }

    private GcdExtend ExtendedEuclidCalc(int a, int m) {
        GcdExtend aa = new GcdExtend();
        if (m == 0) {
            aa.gcd = a;
            aa.x = 1;
            aa.y = 0;
        } else {
            GcdExtend bb = ExtendedEuclidCalc(m, a % m);
            aa.gcd = bb.gcd;
            aa.x = bb.y;
            aa.y = bb.x - bb.y * (a / m);
        }
        return aa;
    }

    public int getModuleInverse() {
        int modInverse = (gcdExtend.x < 0 ? gcdExtend.x + m : gcdExtend.x);
        return modInverse;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        if (a == 1 || m == 1) {
            cb.append('1');
        } else if (gcd(a, m) != 1) {
            cb.append("Not Exist");
        } else {
            cb.append(""+getModuleInverse());
        }
        cb.append("");

        return 10;
    }

    public static int modInverse(int a, int m) {
        ModuleInverse moduleInverse = new ModuleInverse(a, m);
        return moduleInverse.getModuleInverse();
    }

    public static void main(String[] args) {
        System.out.println(ModuleInverse.modInverse(7, 10000));
    }
}
