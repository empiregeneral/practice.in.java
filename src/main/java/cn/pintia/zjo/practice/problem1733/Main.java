package cn.pintia.zjo.practice.problem1733;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            CharSequence one = input.next();
            CharSequence two = input.next();
            Readable readable = new CommonSubsequence(one, two);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
