package cn.edu.hdu.acm.problem1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Byte[] ReadBoard(BufferedReader input) throws IOException {
        Byte[] boardcontents = new Byte[81];
        for(int y=0; y<9; y++) {
            String s = input.readLine();
            for(int x=0; x<9; x++) {
                String n = ""+s.charAt(x);
                boardcontents[x+9*y]=Byte.parseByte(n);
            }
        }
        return boardcontents;
    }

    public void InstanceMain() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        int N = Integer.parseInt(stdin.readLine());
        TestCase[] cases = new TestCase[N];

        for (int i=0; i<N; i++) {
            Byte[] lastWeek = ReadBoard(stdin);
            Byte[] thisSudoku = ReadBoard(stdin);
            if (i<N-1) {
                stdin.readLine();
            }
            cases[i]=new TestCase(lastWeek, thisSudoku);
        }

        Solver solver = new Solver(cases);
        solver.Solve();

        for (int i=0; i<N; i++) {
            if (cases[i].IsSolved())
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main instance = new Main();
        instance.InstanceMain();
    }

}
