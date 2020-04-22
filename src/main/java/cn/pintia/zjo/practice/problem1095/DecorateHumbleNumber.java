package cn.pintia.zjo.practice.problem1095;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class DecorateHumbleNumber implements Readable, Printable {
    private int count = 1;
    private int n;
    private Scanner input;
    private Readable readable;


    public DecorateHumbleNumber(int key) {
        n = key;
        readable = new FindHumbleNumber(key);
        input =  new Scanner(readable);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }
        while(input.hasNext()) {
            int value = input.nextInt();
            if ( n % 10 == 1 && n % 100 != 11) {
                cb.append(String.format("The %dst humble number is %d.", new Object[]{n, value}));
            } else if ( n % 10 == 2 && n % 100 != 12 ) {
                cb.append(String.format("The %dnd humble number is %d.", new Object[]{n, value}));
            } else if ( n % 10 == 3 && n % 100 != 13) {
                cb.append(String.format("The %drd humble number is %d.", new Object[]{n, value}));
            } else {
                cb.append(String.format("The %dth humble number is %d.", new Object[]{n, value}));
            }
        }

        return 10;
    }

    @Override
    public Readable print() {
        return this;
    }
}
