package org.poj.problem2676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 9;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int _cases = Integer.parseInt(stdin.readLine());
        for (int _case = 0; _case < _cases;_case++) {
            Cell[][] cells = new Cell[N][N];
            for (int row = 0; row < N ; row++) {
                String line = stdin.readLine();
                for (int col = 0; col < N; col++) {
                    cells[row][col] = Cell.valueOf(row, col, line.charAt(col));
                }
            }
            SudokuSolver readable = new Backtrace(cells, N);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
        stdin.close();
    }

}
