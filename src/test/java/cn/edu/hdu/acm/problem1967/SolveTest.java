package cn.edu.hdu.acm.problem1967;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(JUnitParamsRunner.class)
public class SolveTest {

    private Board board;
    static int[] permutationSwaps1 = {0,1,0,0,1,0};
    static int[] permutationSwaps2 = {1,2,2,1,2,2};

    @Before
    public void init() {
        board = Board.getInstance();

    }

    @Test
    @FileParameters(value = "src/test/resources/data_hdu_1967.csv", mapper = TestCaseMapper.class)
    public void testRows2(TestCase testCase) {
        Solver solver = new Solver(new TestCase[]{testCase});
        solver.CheckSolution(board);
    }






}
