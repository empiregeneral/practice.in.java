package cn.pintia.zjo.practice.problem1002;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));

        while(input.hasNext()) {
            int size = Integer.parseInt(input.next());
            if ( size == 0) {
                break;
            } else {
                List<char[]> board = new ArrayList();
                for (int i = 0; i < size; i++) {
                    char[] rows = input.next().toCharArray();
                    board.add(rows);
                }
                Scanner output = new Scanner(new Solution(board, true));
                while(output.hasNext()) {
                    System.out.println(output.next());
                }
            }
        }
    }
}
