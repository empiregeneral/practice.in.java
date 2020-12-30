package cn.edu.hdu.acm.problem1967;

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
    @Parameters
    public void testRows2() {

        for (int i = 0; i < 6; i++) {
            board.SwapRows(6+permutationSwaps1[i], 6+permutationSwaps2[i]);
        }
        System.out.println(Arrays.toString(board.get_boardcontents()));
    }
}
