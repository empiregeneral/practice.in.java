package cn.edu.hdu.acm.problem1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solver {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        int N = Integer.parseInt(stdin.readLine());
        TestCase[] cases = new TestCase[N];

        for (int i = 0; i < N; i++) {
            byte[] lastWeek = ReadBoard(stdin);
            byte[] thisSudoku = ReadBoard(stdin);
            if (i<N-1) {
                stdin.readLine();
            }
            cases[i] = new TestCase(lastWeek, thisSudoku);
        }

        for (TestCase testCase : cases) {
            System.out.println(testCase.toString());
        }



    }

    private static class TestCase  {
        byte[] _lastWeek;
        int[][] _givenNumbers;

        public TestCase(byte[] lastWeek, byte[] thisSudoku) {
            _lastWeek = lastWeek;
            _givenNumbers = new int[10][];

            for (int j=1; j<=10; j++) {
                int n = 0;
                int[] temp = new int[81];

                for (int i=0; i<81; i++) {
                    if (thisSudoku[i]==j) {
                        temp[n]=i;
                        n++;
                    }
                }

                _givenNumbers[j-1] = new int[n];
                for(int i=0; i<n; i++)
                {
                    _givenNumbers[j-1][i]=temp[i];
                }
            }
        }

        @Override
        public String toString() {
            return "TestCase{" +
                    "_lastWeek=" + Arrays.toString(_lastWeek) +
                    ", _givenNumbers=" + Arrays.deepToString(_givenNumbers) +
                    '}';
        }
    }

    private static byte[] ReadBoard(BufferedReader input) throws IOException {
        byte[] boardcontents = new byte[81];
        for(int y=0; y<9; y++) {
            String s = input.readLine();
            for(int x=0; x<9; x++) {
                String n = ""+s.charAt(x);
                boardcontents[x+9*y]=Byte.parseByte(n);
            }
        }
        return boardcontents;
    }

}
