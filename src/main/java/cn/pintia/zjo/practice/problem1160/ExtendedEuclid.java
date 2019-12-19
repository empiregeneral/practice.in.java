package cn.pintia.zjo.practice.problem1160;

/**
 * @ClassName: ExtendedEuclid
 * @Description: Inverse Module
 * @Author :lei.zhu
 * @Date 2019/12/10 11:16
 * @Version 1.0
 **/
public class ExtendedEuclid {
    private static final class GcdExtend {
        public int x;
        public int y;
        public int gcd;
    }

    public static int gcd(int a, int b) {
        int r = 0;

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

    public ExtendedEuclid(int a, int m) {
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
}
