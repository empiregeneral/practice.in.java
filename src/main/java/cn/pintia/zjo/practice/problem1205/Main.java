package cn.pintia.zjo.practice.problem1205;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: zjo 1205，消耗的时间121ms
 *               内存10972KB
 * @Author :lei.zhu
 * @Date 2019/12/16 14:08
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            String one = input.nextLine();
            String two = input.nextLine();
            Scanner out = new Scanner(new MartianAddition(one, two));
            while(out.hasNext()) {
                System.out.println(out.next());
            }
        }
    }
}
