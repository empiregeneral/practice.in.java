package cn.edu.hdu.acm.problem2035;

import java.io.IOException;
import java.nio.CharBuffer;

public class BinaryExponentiation implements Readable{
    private int base;
    private int power;
    private final int mod;

    private int count = 1;

    public BinaryExponentiation(int base, int power, int mod) {
        this.base = base;
        this.power = power;
        this.mod = mod;
    }

    private int calculation() {
        int result = 1;

        while(power > 0) {
            if ((power & 1) == 1) {
                result = ((result % mod ) * (base % mod)) % mod;
            }

            base = ((base % mod) * (base % mod)) % mod;

            power >>= 1;
        }

        return result;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }


        cb.append("" + calculation());

        return 10;
    }
}
