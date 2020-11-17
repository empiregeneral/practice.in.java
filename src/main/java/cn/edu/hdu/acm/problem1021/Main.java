package cn.edu.hdu.acm.problem1021;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            int n = input.nextInt();
            if ((n - 2) % 4 == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
