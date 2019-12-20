package cn.pintia.zjo.practice.problem1295;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; i++) {
            String text = input.nextLine();
            Scanner output = new Scanner(new ReverseText(text));
            System.out.print(output.nextLine());
            System.out.println();
        }
    }
}
