package cn.edu.hdu.acm.problem1211;

import cn.edu.hdu.acm.problem2035.BinaryExponentiation;
import cn.pintia.zjo.practice.problem3609.ModuleInverse;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description
 * e为公钥，d为私钥
 * 1. 输入p q e和加密编码串
 * 2. 计算d，算法为 d * e mod((p-1)*(q-1)) = 1 mod ((p-1) *(q-1)) 且 gcd(e, (p-1) * (q-1)) = 1
 * 2.1. 通过扩展欧几里得算法求取d = ModuleInverse(e, (p-1)*(q-1))
 * 3. 密文通过私钥来解密：PlainText(m) = c^d mod (p * q)
 * 3.1 d一般很大，使用快速幂可以轻易求出
 * @author Administrator
 */
public class RsaDecipherMachine {
    private BigInteger p;
    private BigInteger q;
    private BigInteger fn;
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;

    private BigInteger[] cipherCodes;

    private BigInteger[] decipherCodes;

    public RsaDecipherMachine(BigInteger[] cipherCodes, BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = p.multiply(q);
        this.fn = (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
        this.cipherCodes = cipherCodes;
        this.d = e.modInverse(fn);
        this.decipherCodes = decipher(this.cipherCodes);
    }


    /**
     * @Description: 密文通过私钥来解密
     * @param cipherCodes
     * @return
     */
    private BigInteger[] decipher(BigInteger[] cipherCodes) {
        Stream<BigInteger> stream = Arrays.stream(cipherCodes).map(item -> {
            BigInteger integer = item.modPow(d, n);
            return integer;
        });

        return stream.toArray(BigInteger[]::new);
    }

    public BigInteger[] getDecipherCodes() {
        return decipherCodes;
    }

}
