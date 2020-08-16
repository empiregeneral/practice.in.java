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
           LcDisplay.Display(scale, digits.toCharArray());
        }
    }
}