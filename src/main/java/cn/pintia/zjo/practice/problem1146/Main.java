package cn.pintia.zjo.practice.problem1146;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while (input.hasNext()) {
            int scale = input.nextInt();
            int num = input.nextInt();
            if (scale == 0) {
                break;
            }
        }
    }

    private static char[] digitToCharArr(int num) {
        return Integer.toString(num, 10).toCharArray();
    }
}