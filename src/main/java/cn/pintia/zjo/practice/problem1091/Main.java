package cn.pintia.zjo.practice.problem1091;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split(" ");
            Readable readable = new Solution(input[0], input[1]);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
