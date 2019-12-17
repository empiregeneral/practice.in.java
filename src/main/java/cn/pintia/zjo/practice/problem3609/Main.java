package cn.pintia.zjo.practice.problem3609;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description: zju 3609 如果用Readable接口实现的话，占用内存太多了
 * 具体原因需要再分析
 * @Author :lei.zhu
 * @Date 2019/12/17 17:08
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int cases = scanner.nextInt();

        while (cases > 0) {
            int a = scanner.nextInt();
            int m = scanner.nextInt();
            Scanner output = new Scanner(new ModuleInverse(a, m));
            System.out.println(output.nextLine());

            /**
             *            if (a == 1 || m == 1) {
             *                 System.out.println("1");
             *             } else if (ModuleInverse.gcd(a, m) != 1) {
             *                 System.out.println("Not Exist");
             *             } else {
             *                 ModuleInverse mi = new ModuleInverse(a, m);
             *                 System.out.println(mi.getModuleInverse());
             *             }
             **/
            cases--;
        }
    }
}
