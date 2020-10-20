package cn.edu.hdu.acm.problem1021;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//
//
//        int[] tmp = new int[100];
//        tmp[0] = 7 % 3;
//        tmp[1] = 11 % 3;
//
//        for (int i = 2; i < 100; i++) {
//            tmp[i] = (tmp[i - 1] % 3 + tmp[i - 2] % 3) % 3;
//        }
//
//        List<Integer> list = new ArrayList<>();
//
//        for (int index = 0; index < tmp.length; index++) {
//            if (tmp[index] == 0) {
//               list.add(index);
//            }
//        }
//
//        System.out.println(Arrays.toString(tmp));
//        System.out.println(Arrays.toString(list.toArray()));

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
