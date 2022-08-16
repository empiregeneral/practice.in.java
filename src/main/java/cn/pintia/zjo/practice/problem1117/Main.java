package cn.pintia.zjo.practice.problem1117;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String inputText = scanner.nextLine();
            if (inputText.equals("END")) {
                break;
            }
            Scanner output = new Scanner(new Solution(inputText));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
