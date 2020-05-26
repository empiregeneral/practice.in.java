package cn.pintia.zjo.practice.problem1243;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Pattern pattern = Pattern.compile("([A-Za-z]+):");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        System.out.println(scanner.hasNext(pattern));
//        while(scanner.hasNext(P)) {
//            System.out.println(scanner.next());
//        }
    }
}
