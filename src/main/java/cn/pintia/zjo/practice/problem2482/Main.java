package cn.pintia.zjo.practice.problem2482;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            int cases = scanner.nextInt();
            for (int n = 0; n < cases; n++) {
                String bits = scanner.next();
                Readable readable = new TransformBinaryToDecimal(bits);
                Scanner output = new Scanner(readable);
                while(output.hasNextLine()) {
                    System.out.println(output.nextLine());
                }
            }
        }
    }
}
