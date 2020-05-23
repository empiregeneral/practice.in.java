package cn.pintia.zjo.practice.problem1094;

import java.io.BufferedInputStream;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static class Matrix {
        char name;
        int row;
        int column;

        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Matrix() {
            this(0, 0);
        }

        @Override
        public String toString() {
            return "Matrix{" +
                    "name=" + name +
                    ", row=" + row +
                    ", column=" + column +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        Matrix[] matrices;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            matrices = new Matrix[n];
            for (int i = 0; i < n; i++) {
                matrices[i] = new Matrix();
                matrices[i].name = scanner.next().charAt(0);
                matrices[i].row = scanner.nextInt();
                matrices[i].column = scanner.nextInt();
            }
            String expression = "";
            while (scanner.hasNext()) {
                expression = scanner.next();
                if (expression.length() == 1) {
                    System.out.println("0");
                    continue;
                }
                Stack<Matrix> stack = new Stack<>();
                int sum = 0;
                boolean error = false;
                for (int i = 0; i < expression.length(); i++) {
                    if (expression.charAt(i) >= 'A' && expression.charAt(i) <= 'Z') {
                        stack.push(matrices[expression.charAt(i) - 'A']);
                    } else if (expression.charAt(i) == ')') {
                        Matrix m2 = stack.peek();
                        stack.pop();
                        Matrix m1 = stack.peek();
                        stack.pop();
                        if (m2.row != m1.column) {
                            error = true;
                            break;
                        }
                        sum += m1.row * m1.column * m2.column;
                        stack.push(new Matrix(m1.row, m2.column));
                    } else {
                        continue;
                    }
                }
                if (!error) {
                    System.out.println(sum);
                } else {
                    System.out.println("error");
                }
            }
        }
    }
}
