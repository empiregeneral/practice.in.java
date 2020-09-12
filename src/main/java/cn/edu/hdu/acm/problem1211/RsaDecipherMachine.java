package cn.edu.hdu.acm.problem1211;

import cn.edu.hdu.acm.problem2035.BinaryExponentiation;
import cn.pintia.zjo.practice.problem3609.ModuleInverse;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description
 * e为公钥，d为私钥
 * 1. 输入p q e和加密编码串
 * 2. 计算d，算法为 d * e mod((p-1)*(q-1)) = 1 mod ((p-1) *(q-1)) 且 gcd(e, (p-1) * (q-1)) = 1
 * 2.1. 通过扩展欧几里得算法求取d = ModuleInverse(e, (p-1)*(q-1))
 * 3. PlainText(m) = c^d mod (p * q)
 * 3.1 d一般很大，使用快速幂可以轻易求出
 * @author Administrator
 */
public class RsaDecipherMachine {
    private int p;
    private int q;
    private int fn;
    private int n;
    private int e;
    private int d;

    private Integer[] cipherCodes;

    private Integer[] decipherCodes;

    public RsaDecipherMachine(Integer[] cipherCodes, int p, int q, int e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.n = p * q;
        this.fn = (p - 1) * (q - 1);
        this.cipherCodes = cipherCodes;
        this.d = ModuleInverse.modInverse(e, fn);
        this.decipherCodes = decipher(this.cipherCodes);
    }


    /**
     * @Description: 密文通过私钥来解密
     * @param cipherCodes
     * @return
     */
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

}
