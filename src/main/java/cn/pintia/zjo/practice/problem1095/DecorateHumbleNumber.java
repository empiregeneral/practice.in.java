package cn.pintia.zjo.practice.problem1095;

import java.io.IOException;
import java.nio.CharBuffer;

public class DecorateHumbleNumber implements Readable, Printable {
    private int count = 1;
    private int key;
    private int value;

    public DecorateHumbleNumber(int key, int[] table) {
        this.key = key;
        this.value = table[this.key - 1];
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        if ((key % 10 == 1) && (key / 10 % 10 != 1)) {
            cb.append(String.format("The %dst humble number is %d.", new Object[]{key, value}));
        } else if ((key % 10 == 2) && (key / 10 % 10 != 1)) {
            cb.append(String.format("The %dnd humble number is %d.", new Object[]{key, value}));
        } else if ((key % 10 == 3) && (key / 10 % 10 != 1)) {
            cb.append(String.format("The %drd humble number is %d.", new Object[]{key, value}));
        } else {
            cb.append(String.format("The %dth humble number is %d.", new Object[]{key, value}));
        }

        return 10;
    }

    @Override
    public Readable print() {
        return this;
    }
}
