package cn.edu.hdu.acm.problem3117;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            int N = scanner.nextInt();
            Readable readable = new PrintFibonacci(N);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
