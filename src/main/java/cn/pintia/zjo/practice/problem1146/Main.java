package cn.pintia.zjo.practice.problem1146;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while (input.hasNext()) {
            int scale = input.nextInt();
            String digits = input.next();
            if (scale == 0) {
                break;
            }
            Scanner out = new Scanner(new LcDisplay(scale, digits.toCharArray()));
            while(out.hasNextLine()) {
                System.out.println(out.nextLine());
            }
        }
    }
}