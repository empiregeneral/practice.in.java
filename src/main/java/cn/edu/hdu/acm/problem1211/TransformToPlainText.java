package cn.edu.hdu.acm.problem1211;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Arrays;
import java.util.Scanner;

public class TransformToPlainText implements Readable {

    private int count = 1;
    private RsaDecipherMachine decipherMachine;
    private Integer[] decipherCodes;

    public TransformToPlainText(Integer[] cipherCode, int p, int q, int e){
        decipherMachine = new RsaDecipherMachine(cipherCode, p, q, e);
        decipherCodes = decipherMachine.getDecipherCodes();
    }

    /**
     * Attempts to read characters into the specified character buffer.
     * The buffer is used as a repository of characters as-is: the only
     * changes made are the results of a put operation. No flipping or
     * rewinding of the buffer is performed.
     *
     * @param cb the buffer to read characters into
     * @return The number of {@code char} values added to the buffer,
     * or -1 if this source of characters is at its end
     * @throws IOException             if an I/O error occurs
     * @throws NullPointerException    if cb is null
     * @throws ReadOnlyBufferException if cb is a read only buffer
     */
    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        Character[] chars = Arrays.stream(decipherCodes).map(e -> {
            char ch = (char)e.intValue();
            return Character.valueOf(ch);
        }).toArray(Character[]::new);

        for (Character character : chars) {
            cb.append(character.charValue());
        }

        return 10;
    }

    public static void main(String[] args) {
        Readable readable = new TransformToPlainText(new Integer[]{7716, 7746, 7497, 126, 8486, 4708, 7746, 623, 7298, 7357, 3239}, 103, 101, 7);
        Scanner output = new Scanner(readable);
        while(output.hasNext()) {
            System.out.println(output.next());
        }
    }
}
