package cn.pintia.zjo.practice.problem2645;

import cn.pintia.zjo.practice.problem2482.BinaryToDecimal;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryStrToIpAddress {
    private String binaryIP;
    private final String regex = "(?<=[01])(?=([01]{8})+(?![01]))";
    private final String delimiter = ".";
    private final String delimiterRegex = "\\.";
    private String output;

    public BinaryStrToIpAddress(String input) {
        binaryIP = input.replaceAll(regex, delimiter);
        output = output(binaryIP);
    }

    private String output(String binaryIP) {
        String result = Arrays.stream(binaryIP.split(delimiterRegex)).map(BinaryToDecimal::transform).collect(Collectors.joining(delimiter));
        return result;
    }

    private static class BinaryToDecimal {
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

    public static String valueOf(String input) {
        return new BinaryStrToIpAddress(input).output;
    }

}
