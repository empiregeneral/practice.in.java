package org.poj.problem2676;

/**
 * @author canmozhang
 */
public interface SudokuSolver extends Readable{
    boolean solve(Byte[][] board, int n);
    void print(Byte[][] board, int n);
}
