package cn.pintia.zjo.practice.problem1797;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @ClassName: Main
 * @Description: zju 1797
 * @Author :lei.zhu
 * @Date 2019/12/16 14:37
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedInputStream(System.in));

        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = input.nextInt();
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = input.nextInt();
            }
            Arrays.sort(array);
            LeastCommonMultiple lcm = new LeastCommonMultiple(array);
            System.out.println(lcm.getLcm());
        }
    }
}
