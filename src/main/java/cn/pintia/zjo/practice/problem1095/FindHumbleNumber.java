package cn.pintia.zjo.practice.problem1095;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class FindHumbleNumber implements Readable {
    private int count = 1;
    private Generate<Integer> generate = new HumbleNumberGenerate();
    private int index;
    private Integer[] humbleNumbers;

    public FindHumbleNumber(int key) {
        this.index = key - 1;
        humbleNumbers = generate.createTable();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append("" + humbleNumbers[index]);
        cb.append("");

        return 10;
    }

    public static void main(String[] args) {
        Readable readable = new FindHumbleNumber(5842);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
