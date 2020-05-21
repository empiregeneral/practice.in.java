package cn.pintia.zjo.practice.problem2482;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformBinaryToDecimal implements Readable {
    private int count = 1;
    private String binaryIP;
    private final String regex = "(?<=[01])(?=([01]{8})+(?![01]))";
    private final String delimiter = ".";
    private final String delimiterRegex = "\\.";

    public TransformBinaryToDecimal(String input) {
        binaryIP = input.replaceAll(regex, delimiter);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }
        String output =  Arrays.stream(binaryIP.split(delimiterRegex)).map(BinaryToDecimal::transform).collect(Collectors.joining(delimiter));
        cb.append(output);
        return 10;
    }
}
