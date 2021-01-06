package cn.pintia.zjo.practice.problem3122;

public class Cell {
    /**
     *  外部状态
     */
    protected int _row;
    /**
     * 外部状态
     */
    protected int _column;
    /**
     *  内部状态
     */
    protected Face value;

    public enum Face {
        EMPTY('-'),
        A('A'),
        B('B'),
        C('C'),
        D('D'),
        E('E'),
        F('F'),
        G('G'),
        H('H'),
        I('I'),
        J('J'),
        K('K'),
        L('L'),
        M('M'),
        N('N'),
        O('O'),
        P('P');

        final private char token;

        Face(char token) {
            this.token = token;
        }

        public char getToken() {
            return token;
        }

        public static Face getFace(char token) {
            for (Face face : values()) {
                if ( token == face.getToken()) {
                    return face;
                }
            }
            throw new IllegalArgumentException("Invalid token");
        }
    }

    public Cell(int row, int column, char token) {
        this._row = row;
        this._column = column;
        this.value = Face.getFace(token);
    }

    public static Cell valueOf(int row, int col, char token) {
        return new Cell(row, col, token);
    }
}
