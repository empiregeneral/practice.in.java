package cn.pintia.zjo.practice.problem1095;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextInt()) {
            int key = input.nextInt();
            if (key == 0) {
                break;
            }
            Readable readable = new DecorateHumbleNumber(key);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }

    }
}
