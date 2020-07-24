package cn.pintia.zjo.practice.problem1975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(in);
        while(st.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)st.nval;
            if (n == 0) {
                break;
            }
            int xlen = 1 << n;
            int ylen = 2 << n;
            char[][] out = new char[xlen][ylen];
            for (int i = 0; i < xlen; i++) {
                for (int j = 0; j < ylen; j++) {
                    out[i][j] = '*';
                }
            }
            System.out.println(Arrays.deepToString(out));


        }
    }
}
