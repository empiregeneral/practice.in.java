package cn.edu.hdu.acm.problem1211;

import cn.edu.hdu.acm.problem2035.BinaryExponentiation;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

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
        cipherCodes = cipher(this.plainCodes);
    }

    private Integer[] cipher(Integer[] plainCodes) {
        Stream<Integer> stream = Arrays.stream(plainCodes).map(item -> {
           BigInteger integer = new BigInteger(String.valueOf(item)).modPow(e, n);
           return Integer.parseInt(integer.toString());
        });
        return stream.toArray(Integer[]::new);
    }


    public Integer[] getCipherCodes() {
        return cipherCodes;
    }






}
