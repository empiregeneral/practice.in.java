package cn.edu.hdu.acm.problem1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] permutationSwaps1 = {0,1,0,0,1,0};
    static int[] permutationSwaps2 = {1,2,2,1,2,2};


    class Solver {
        TestCase[] _cases;

        public Solver(TestCase[] cases) {
            _cases = cases;
        }

        void TestRotations(Board src) {
            TestRowSegments(src);
            src.Rotate();
            TestRowSegments(src);
            src.Rotate();
            src.Rotate();
            src.Rotate();
        }

        void TestRowSegments(Board src) {
            for (int i=0; i<6; i++) {
                TestColumnSegments(src);
                src.SwapRowSegments(permutationSwaps1[i],permutationSwaps2[i]);
            }
        }

        void TestColumnSegments(Board src) {
            for (int i=0; i<6; i++) {
                TestColumns0(src);
                src.SwapColumnSegments(permutationSwaps1[i],permutationSwaps2[i]);
            }
        }

        void TestColumns0(Board src) {
            for (int i=0; i<6; i++) {
                TestRows0(src);
                src.SwapColumns(permutationSwaps1[i],permutationSwaps2[i]);
            }
        }

        void TestRows0(Board src) {
            for (int i=0; i<6; i++) {
                TestColumns1(src);
                src.SwapRows(permutationSwaps1[i],permutationSwaps2[i]);
            }
        }

        void TestColumns1(Board src) {
            for (int i=0; i<6; i++) {
                TestRows1(src);
                src.SwapColumns(3+permutationSwaps1[i],3+permutationSwaps2[i]);
            }
        }

        void TestRows1(Board src) {
            for (int i=0; i<6; i++) {
                TestColumns2(src);
                src.SwapRows(3+permutationSwaps1[i],3+permutationSwaps2[i]);
            }
        }

        void TestColumns2(Board src) {
            for (int i=0; i<6; i++) {
                TestRows2(src);
                src.SwapColumns(6+permutationSwaps1[i],6+permutationSwaps2[i]);
            }
        }

        void TestRows2(Board src) {
            for (int i=0; i<6; i++) {
                CheckSolution(src);
                src.SwapRows(6+permutationSwaps1[i],6+permutationSwaps2[i]);
            }
        }

        void CheckSolution(Board src) {
            for (int i=0; i<_cases.length; i++) {
                _cases[i].TryBoard(src);
            }
        }

        public void Solve() {
            TestRotations(new Board());
        }
    }

    class Board {
        byte[] _boardcontents;

        public Board() {
            _boardcontents = new byte[81];
            for (byte i=0; i<81; i++) {
                _boardcontents[i]=i;
            }
        }

        void SwapCells(int x1, int y1, int x2, int y2) {
            byte tempValue = _boardcontents[x1+9*y1];
            _boardcontents[x1+9*y1]=_boardcontents[x2+9*y2];
            _boardcontents[x2+9*y2]=tempValue;
        }

        public void SwapRows(int row1, int row2) {
            for (int x=0; x<9; x++) {
                SwapCells(x,row1,x,row2);
            }
        }

        public void SwapColumns(int col1, int col2) {
            for (int y=0; y<9; y++) {
                SwapCells(col1,y,col2,y);
            }
        }

        public void SwapRowSegments(int seg1, int seg2) {
            SwapRows(3*seg1+0,3*seg2+0);
            SwapRows(3*seg1+1,3*seg2+1);
            SwapRows(3*seg1+2,3*seg2+2);
        }

        public void SwapColumnSegments(int seg1, int seg2) {
            SwapColumns(3*seg1+0,3*seg2+0);
            SwapColumns(3*seg1+1,3*seg2+1);
            SwapColumns(3*seg1+2,3*seg2+2);
        }

        public void Rotate() {
            byte[] newContents = (byte[]) _boardcontents.clone();

            for (int x=0; x<9; x++) {
                for (int y=0; y<9; y++) {
                    newContents[x+9*y]=_boardcontents[y+9*(8-x)];
                }
            }
            _boardcontents=newContents;
        }


        public boolean Matches(byte[] lastweek, int[][] candidate) {
            int mbSum = 0;

            for (int i=0; i<10; i++) {
                int[] positions = candidate[i];

                if (positions.length>0) {
                    byte matchbyte = lastweek[_boardcontents[positions[0]]];

                    int mask = 1 << (matchbyte-1);
                    if ((mbSum & mask) != 0)
                    {
                        return false;
                    }
                    mbSum |= mask;

                    for (int j=1; j<positions.length; j++) {
                        if (matchbyte != lastweek[_boardcontents[positions[j]]]){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    class TestCase {
        byte[] _lastWeek;
        int[][] _givenNumbers;

        boolean _solved;

        public TestCase(byte[] lastWeek, byte[] thisSudoku) {
            _lastWeek = lastWeek;
            _givenNumbers = new int[10][];
            _solved = false;

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

        public void TryBoard(Board candidate) {
            if (!_solved) {
                _solved = candidate.Matches(_lastWeek, _givenNumbers);
            }
        }

        public boolean IsSolved() {
            return _solved;
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

    public void InstanceMain() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);

        int N = Integer.parseInt(stdin.readLine());
        TestCase[] cases = new TestCase[N];

        for (int i=0; i<N; i++) {
            byte[] lastWeek = ReadBoard(stdin);
            byte[] thisSudoku = ReadBoard(stdin);
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
