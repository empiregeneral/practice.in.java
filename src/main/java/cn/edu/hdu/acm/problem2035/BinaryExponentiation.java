package cn.edu.hdu.acm.problem2035;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Readable readable = new BinaryExponentiation(7716, 8743, 10403);
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            System.out.println(output.nextLine());
        }
    }
}
