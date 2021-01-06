package cn.pintia.zjo.practice.problem3122;

public interface SudokuSolver extends Readable {
    boolean solve(Character[][] board, int n);
    void print(Character[][] board, int n);
}
