package cn.edu.hdu.acm.problem1211;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description
 * 加密用的是输入私钥
 *  e为公钥，d为私钥
 *  1. 输入p q d和明文字符串 PlainText(m)
 *  2. 计算e, 算法为 d * e mod ((p-1) * (q-1)) = 1 mod((p-1) * (q-1))
 *  2.1 通过扩展欧几里得算法求 e: e = ModuleInverse(d, (p-1) * (q-1))
 *  3. E(c) = plaintext(c) ^ e mod (p * q)
 *  3.1 用快速幂算法求解E(c)
 *  */

public class RsaCipherMachine {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger fn;
    private Integer[] plainCodes;


    private BigInteger[] cipherCodes;
    private BigInteger d;
    private BigInteger e;

    public RsaCipherMachine(Integer[] plainCodes, BigInteger p, BigInteger q, BigInteger d) {
        this.plainCodes = plainCodes;
        this.p = p;
        this.q = q;
        this.d = d;
        this.n = p.multiply(q);
        this.fn = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
        this.e = d.modInverse(fn);
        cipherCodes = cipher(this.plainCodes);
    }

    private BigInteger[] cipher(Integer[] plainCodes) {
        Stream<BigInteger> stream = Arrays.stream(plainCodes).map(item -> {
           BigInteger bigInteger = new BigInteger(String.valueOf(item)).modPow(e, n);
           return bigInteger;
        });
        return stream.toArray(BigInteger[]::new);
    }

    public BigInteger[] getCipherCodes() {
        return cipherCodes;
    }
}
