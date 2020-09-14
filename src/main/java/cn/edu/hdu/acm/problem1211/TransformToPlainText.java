package cn.edu.hdu.acm.problem1211;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TransformToPlainText implements Readable {

    private int count = 1;
    private RsaDecipherMachine decipherMachine;
    private BigInteger[] decipherCodes;

    public TransformToPlainText(BigInteger[] cipherCode, BigInteger p, BigInteger q, BigInteger e){
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
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        List<BigInteger> cipherCodes = new ArrayList<>();
        while(input.hasNext()) {
            cipherCodes.add(toBigInteger(input.next()));
        }

        BigInteger[] bigIntegers = cipherCodes.toArray(new BigInteger[cipherCodes.size()]);

        Readable readable = new TransformToPlainText(bigIntegers,
                                                     new BigInteger("1241386753"),
                                                     new BigInteger("1477535881"),
                                                     new BigInteger("1486062115457948969"));
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            System.out.println(output.nextLine());
        }
    }

    private static BigInteger toBigInteger(int item) {
        return new BigInteger(new Integer(item).toString());
    }

    private static BigInteger toBigInteger(String item) {
        return new BigInteger(item);
    }
}
