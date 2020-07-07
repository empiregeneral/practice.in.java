package cn.pintia.zjo.practice.problem1951;

import java.io.BufferedInputStream;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n == 0 ) {
                break;
            }

            try {
                Readable readable = new FindGoldbachEquationImp(n);
                Scanner output = new Scanner(readable);
                while(output.hasNextLine()) {
                    System.out.println(output.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
