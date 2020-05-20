package cn.pintia.zjo.practice.problem2482;

public class BinaryToDecimal {
    private BinaryToDecimal() {
    }

    private static final int bitLen = 8;
    private static final int radix = 2;

    public static String transform(String bits) {
        if (bits.length() != bitLen) {
            throw new IllegalArgumentException("The bits is invalided");
        }

        return Integer.valueOf(bits, radix).toString();
    }
}
