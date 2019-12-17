package cn.pintia.zjo.practice.problem1113;

import java.util.Scanner;

/**
 * @ClassName: UCalculationE
 * @Description: zju 1113
 * @Author :lei.zhu
 * @Date 2019/11/25 10:46
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Readable readable = new UcalcutionE();
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}