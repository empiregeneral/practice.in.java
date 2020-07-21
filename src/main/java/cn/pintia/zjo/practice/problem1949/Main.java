package cn.pintia.zjo.practice.problem1949;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            int scales = input.nextInt();
            if (scales == 0) {
                break;
            }
            int[][] matrix = new int[scales][scales];
            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < matrix[0].length; column++) {
                    matrix[row][column] = input.nextInt();
                }
            }

            Scanner output = new Scanner(new ErrorCorrection(matrix));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
