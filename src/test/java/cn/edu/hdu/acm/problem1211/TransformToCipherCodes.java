package cn.edu.hdu.acm.problem1211;

import java.math.BigInteger;

public class TransformToCipherCodes {
    private Integer[] cipherCodes;
    private char[] characters;
    private RsaCipherMachine rsaCipherMachine;
    private BigInteger p;
    private BigInteger q;
    private BigInteger d;

    public TransformToCipherCodes(String plainText, BigInteger p, BigInteger q, BigInteger d) {
        this.characters = plainText.toCharArray();
    }

}
