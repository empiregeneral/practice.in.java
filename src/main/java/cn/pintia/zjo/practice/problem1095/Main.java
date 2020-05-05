package cn.pintia.zjo.practice.problem1095;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    private static Generate generate = new HumbleNumberGenerate(200000);

    public static void main(String[] args) {
        int[] humbleTable = generate.createTable();

        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextInt()) {
            int n = input.nextInt();
            if (n == 0) {
                break;
            }
            Readable readable = new DecorateHumbleNumber(n, humbleTable);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }

    }
}
