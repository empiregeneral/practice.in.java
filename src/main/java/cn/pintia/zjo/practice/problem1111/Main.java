package cn.pintia.zjo.practice.problem1111;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            Readable readable = new ShowHandInDeck(input.nextLine());
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
