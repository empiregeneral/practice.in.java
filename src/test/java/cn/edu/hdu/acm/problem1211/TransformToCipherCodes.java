package cn.edu.hdu.acm.problem1211;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class TransformToCipherCodes {

    private Integer[] cipherCodes;
    private Integer[] plainCodes;
    private char[] chars;
    private String plainText;
    private RsaCipherMachine rsaCipherMachine;
    private BigInteger p;
    private BigInteger q;
    private BigInteger d;

    public TransformToCipherCodes(String plainText, BigInteger p, BigInteger q, BigInteger d) {
        this.plainText = plainText;
        this.chars = this.plainText.toCharArray();
        this.plainCodes = toPlainCodes(chars);
        rsaCipherMachine = new RsaCipherMachine(this.plainCodes, p, q, d);
        cipherCodes = rsaCipherMachine.getCipherCodes();
    }

    private Integer[] toPlainCodes(char[] chars) {
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = Character.valueOf(chars[i]);
        }

        Stream<Integer> stream = Arrays.stream(characters).map(ch -> {
            Integer integer = Integer.valueOf((int)ch);
            return integer;
        });

        return stream.toArray(Integer[]::new);
    }

    public Integer[] getPlainCodes() {
        return plainCodes;
    }

    public Integer[] getCipherCodes() {
        return cipherCodes;
    }

    public static void main(String[] args) {
        String plainText = "I-LOVE-ACM.";
        TransformToCipherCodes transform = new TransformToCipherCodes(plainText, new BigInteger("103"), new BigInteger("101"), new BigInteger("8743"));
        Integer[] cipherCodes = transform.getCipherCodes();
        System.out.println(Arrays.deepToString(cipherCodes));
    }

}
