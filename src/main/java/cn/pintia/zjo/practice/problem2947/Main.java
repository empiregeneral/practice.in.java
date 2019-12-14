package cn.pintia.zjo.practice.problem2947;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int cases = input.nextInt();
        for (int i = 1; i <= cases; i++) {
            int countOfFirstWords = input.nextInt();
            StringBuilder sb1 = new StringBuilder("");
            for (int j = 0; j < countOfFirstWords; j++) {
                sb1.append(input.next() + " ");
            }
            String firstWords = sb1.toString();

            int countOfSecondWords = input.nextInt();
            StringBuilder sb2 = new StringBuilder("");
            for (int k = 0; k < countOfSecondWords; k++) {
                sb2.append(input.next() + " ");
            }
            String secondWords = sb2.toString();

            Readable readable = new CheckAbbreviation(firstWords, secondWords);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
