package cn.edu.hdu.acm.problem1967;

import java.util.Arrays;

public class Solver {
    static int[] permutationSwaps1 = {0,1,0,0,1,0};
    static int[] permutationSwaps2 = {1,2,2,1,2,2};
    int count = 0;

    TestCase[] _cases;

    public Solver(TestCase[] cases) {
        _cases = cases;
    }


    public void Solve() {
        TestRotations(Board.getInstance());
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
        //System.out.println(Arrays.toString(src.get_boardcontents()));
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
        count++;
        //System.out.println(Arrays.toString(src.get_boardcontents()));
    }

    void CheckSolution(Board src) {

        for (int i=0; i<_cases.length; i++) {
            _cases[i].TryBoard(src);
        }
    }



    public int getCount() {
        return count;
    }
}
