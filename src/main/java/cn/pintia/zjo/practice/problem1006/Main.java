package cn.pintia.zjo.practice.problem1006;

import org.test4j.tools.commons.ResourceHelper;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: zjo 1006
 * @Author :lei.zhu
 * @Date 2019/12/12 11:43
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner input = new Scanner(new BufferedInputStream(System.in));
        Scanner input = new Scanner(ResourceHelper.getResourceAsStream(Main.class, "TestCases_1006.txt"));

        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] content = line.split(" ");
            if (Integer.parseInt(content[0]) == 0) {
                break;
            }
            int key = Integer.parseInt(content[0]);
            String cipherText = content[1];
            Scanner scanner = new Scanner(new Dotheuntwist(key, cipherText));
            System.out.println(scanner.next());
        }
    }
}

class Dotheuntwist implements Readable {
    private char[] lowers = "_abcdefghijklmnopqrstuvwxyz.".toCharArray();
    private int key;
    private String cipherText;
    private Integer[] cipherCode;
    private int n;
    private int count = 1;

    public Dotheuntwist(int key, String cipherText) {
        this.key = key;
        this.cipherText = cipherText;
        this.cipherCode = text2Codes(cipherText);
        this.n = cipherText.length();
    }

    private Integer[] text2Codes(String text) {
        char[] chars = text.toCharArray();
        List<Integer> codes = new ArrayList<>(n);
        for (char ch : chars) {
            codes.add(indexOfArr(lowers, ch));
        }
        return codes.toArray(new Integer[n]);
    }

    /**
     * @Author lei.zhu
     * @Description 解密
     * @Date 11:48 2019/12/12
     * @Param [codes, key]
     * @return java.lang.Integer[]
     **/
    private Integer[] doTheUntwist(Integer[] codes, int key) {
        Integer[] plainCodes = new Integer[n];
        if ( codes == null && key == 0) {
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                plainCodes[(key * i) % n] = (codes[i] + i) % 28;
            }
        }

        return plainCodes;
    }

    private char[] transformPlainChars(Integer[] plainCodes) {
        char[] plainChars = new char[n];
        for (int i = 0; i < n; i++) {
            plainChars[i] = charOf(lowers, plainCodes[i]);
        }

        return plainChars;
    }

    private char charOf(char[] array, int index) {
        return array[index];
    }

    private int indexOfArr(char[] array, char valueToFind) {
        return Arrays.binarySearch(array, valueToFind);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        Integer[] plainCode = doTheUntwist(cipherCode, key);
        char[] plainChars = transformPlainChars(plainCode);

        for (int i = 0; i < n; i++) {
            cb.append(plainChars[i]);
        }
        cb.append("");
        return 10;
    }
}
