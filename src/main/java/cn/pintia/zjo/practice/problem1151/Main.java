package cn.pintia.zjo.practice.problem1151;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int n = Integer.parseInt(input.next());
        for (int i = 0; i < n; i++) {
            int cases = Integer.parseInt(input.next());
            input.nextLine(); /* scanner.next()和scanner.nextLine()处理方式不同, */
            for (int j = 0; j < cases; j++) {
                String sentence = input.nextLine();
                Readable readable = new WordReversal(sentence);
                Scanner sc = new Scanner(readable);
                while(sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }
            if ( i != n-1) { /* Block Input, every block has a blank line.*/
                System.out.println();
            }
        }
    }
}
