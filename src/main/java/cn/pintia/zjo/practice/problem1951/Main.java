package cn.pintia.zjo.practice.problem1951;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
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
