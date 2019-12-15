package cn.pintia.zjo.practice.problem1526;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: TODO
 * @Author :lei.zhu
 * @Date 2019/12/13 17:19
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int cases = input.nextInt();
        for (int i = 0; i < cases; i++) {
            int num = input.nextInt();
            Readable readable = new BigNumber(num);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
