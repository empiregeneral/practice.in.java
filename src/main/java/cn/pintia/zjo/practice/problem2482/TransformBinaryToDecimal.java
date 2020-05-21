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

    public TransformBinaryToDecimal(String input) {
        binaryIP = input.replaceAll(regex, ".");
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }
        List<String> myList =  Arrays.stream(binaryIP.split("\\.")).map(BinaryToDecimal::transform).collect(Collectors.toList());
        cb.append(String.join(".", myList));
        return 10;
    }
}
