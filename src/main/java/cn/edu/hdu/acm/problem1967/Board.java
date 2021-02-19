package cn.edu.hdu.acm.problem1967;

/**
 * @author Administrator
 */
public class Board {


    byte[] _boardcontents;

    private Board() {
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
        assert (seg1 <= 2) && (seg1 >=0);
        assert (seg2 <= 2) && (seg2 >=0);
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

    public byte[] get_boardcontents() {
        return _boardcontents;
    }

    public static Board getInstance() {
        return new Board();
    }

}
