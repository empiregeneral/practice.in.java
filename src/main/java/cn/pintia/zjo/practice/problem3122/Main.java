package cn.pintia.zjo.practice.problem3122;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final int N = 16;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Cell[][] cells = new Cell[N][N];
        for (int row = 0; row < N; row++) {
            String line = stdin.readLine();
            for (int col = 0; col < N; col++) {
                cells[row][col] = Cell.valueOf(row, col, line.charAt(col));
            }
        }

        Readable output = new Backtrace(cells, N);
        Scanner scanner = new Scanner(output);
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        stdin.close();
    }
}
