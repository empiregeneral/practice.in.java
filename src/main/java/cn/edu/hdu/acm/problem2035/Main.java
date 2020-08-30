package cn.edu.hdu.acm.problem2035;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int mod = 1000;

        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            int base = input.nextInt();
            int power = input.nextInt();
            if (base == 0 && power == 0) {
                break;
            }
            Scanner output = new Scanner(new BinaryExponentiation(base, power, mod));
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
