package cn.edu.hdu.acm.problem1967;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class BoardTest {
    private Board board;

    @Before
    public void init() {
        board = Board.getInstance();
        int[] permutationSwaps1 = {0,1,0,0,1,0};
        int[] permutationSwaps2 = {1,2,2,1,2,2};
    }

    @Test
    @Parameters({"0,0,1,0"})
    public void testSwapCell(int x1, int y1, int x2, int y2) {
        board.SwapCells(x1, y1, x2, y2);
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }


    @Test
    @Parameters({"0,1"})
    public void testSwapRows(int row1, int row2) {
        board.SwapRows(row1, row2);
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @Parameters({"0,2"})
    public void testSwapRowSegments(int seg1, int seg2) {
        board.SwapRowSegments(seg1, seg2);
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @Parameters({"0,1"})
    public void testSwapColumns(int column1, int column2) {
        board.SwapColumns(column1, column2);
        System.out.println(Arrays.toString(board.get_boardcontents()));

    }

    @Test
    @Parameters({"0,2"})
    public void testSwapColumnSegments(int seg1, int seg2) {
        board.SwapColumnSegments(seg1, seg2);
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @Parameters({"4","8", "3", "0"})
    public void testRotate(int times) {
        for (int time = 0; time < times; time++) {
            board.Rotate();
        }
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }

    @Test
    @FileParameters(value = "src/test/resources/data_hdu_1967.csv",mapper = BoardMapper.class)
    public void testMatches(List<String> lastWeek, List<String> thisWeek) {
        TestCase _tCase = new TestCase(lastWeek, thisWeek);
        System.out.println(board.Matches(_tCase._lastWeek, _tCase._givenNumbers));

    }

    @After
    public void tearDown() {

    }

}
