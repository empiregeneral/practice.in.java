package cn.pintia.zjo.practice.problem1975;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            int n = Integer.parseInt(input.next());
            if (n==0) {
                break;
            }
            Scanner output = new Scanner(new DrawSierpinskiFractal(n));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
