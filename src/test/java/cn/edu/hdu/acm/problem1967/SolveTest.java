package cn.edu.hdu.acm.problem1967;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
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
    public void testRows0(TestCase testCase) {
        Solver solver = new Solver(new TestCase[]{testCase});
        solver.TestRows0(board);
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @FileParameters(value = "src/test/resources/data_hdu_1967.csv", mapper = TestCaseMapper.class)
    public void testRows1(TestCase testCase) {
        Solver solver = new Solver(new TestCase[]{testCase});
        solver.TestRows1(board);
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @FileParameters(value = "src/test/resources/data_hdu_1967.csv", mapper = TestCaseMapper.class)
    public void testRow0(TestCase testCase) {
        Solver solver = new Solver(new TestCase[]{testCase});
        solver.TestRows0(board);
        System.out.println(solver.getCount());
        //System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @FileParameters(value = "src/test/resources/data_hdu_1967.csv", mapper = TestCaseMapper.class)
    public void testRowSegments(TestCase testCase) {
        Solver solver = new Solver(new TestCase[]{testCase});
        solver.TestRowSegments(board);
        System.out.println(solver.getCount());
    }

}
