package cn.edu.hdu.acm.problem1211;

import cn.edu.hdu.acm.problem2035.BinaryExponentiation;
import cn.pintia.zjo.practice.problem3609.ModuleInverse;

import java.util.Arrays;
import java.util.stream.Stream;

public class RSA {
    private int p;
    private int q;
    private int fn;
    private int n;
    private int e;
    private int d;

    private Integer[] cipherCodes;

    private Integer[] decipherCodes;

    public RSA(Integer[] cipherCodes, int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = p * q;
        this.fn = (p - 1) * (q - 1);
        this.cipherCodes = cipherCodes;
        this.d = ModuleInverse.modInverse(e, fn);
        this.decipherCodes = decipher(this.cipherCodes);
    }

    private Integer[] decipher(Integer[] cipherCodes) {
        Stream<Integer> stream = Arrays.stream(cipherCodes).map(item -> {
            Integer ret = BinaryExponentiation.getResult(item, this.d, this.n);
            return ret;
        });

        return stream.toArray(Integer[]::new);
    }

    public Integer[] getDecipherCodes() {
        return decipherCodes;
    }

    public static void main(String[] args) {
        Integer[] cipherCodes = new Integer[]{7716, 7746, 7497, 126, 8486, 4708, 7746, 623, 7298, 7357, 3239};
        RSA rsa = new RSA(cipherCodes, 101, 103, 7);
        System.out.println(Arrays.deepToString(rsa.getDecipherCodes()));
    }

}
