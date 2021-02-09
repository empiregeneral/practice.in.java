package cn.pintia.zjo.practice.problem2645;

import java.math.BigInteger;

public class Answer {
    public static void main(String[] args) {
        BigInteger i = new BigInteger("194");
        BigInteger C1 =  i.shiftLeft(24);

        BigInteger j = new BigInteger("85");
        BigInteger C2 = j.shiftLeft(16);

        BigInteger p = new BigInteger("160");
        BigInteger C3 = p.shiftLeft(8);

        BigInteger q = new BigInteger("178");
        BigInteger C4 = q.shiftLeft(0);

//        BigInteger i = new BigInteger("194");
//        BigInteger C1 =  i.shiftLeft(24);
//
//        BigInteger j = new BigInteger("85");
//        BigInteger C2 = j.shiftLeft(16);
//
//        BigInteger p = new BigInteger("160");
//        BigInteger C3 = p.shiftLeft(8);
//
//        BigInteger q = new BigInteger("183");
//        BigInteger C4 = q.shiftLeft(0);

        System.out.println(C1.or(C2).or(C3).or(C4).toString(2));

    }
}
