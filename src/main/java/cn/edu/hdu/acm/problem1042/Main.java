package cn.edu.hdu.acm.problem1042;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int n = input.nextInt();

            Readable readable = new Factorial(n);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
