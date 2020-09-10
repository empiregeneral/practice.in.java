package cn.edu.hdu.acm.problem1211;

import java.math.BigInteger;

public class RsaCipherMachine {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger fn;
    private Integer[] plainCodes;
    private Integer[] cipherCodes;
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
    }




}
