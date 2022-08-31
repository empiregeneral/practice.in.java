package cn.pintia.zjo.practice.problem1091;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String start = scanner.next();
            String end = scanner.next();
            Scanner out = new Scanner(new Solution(start, end));
            while(out.hasNextLine()) {
                System.out.println(out.nextLine());
            }
        }
    }
}
