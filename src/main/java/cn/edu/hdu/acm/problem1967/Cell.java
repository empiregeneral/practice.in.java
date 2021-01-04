package cn.edu.hdu.acm.problem1967;

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
        ONE('1'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        ZERO('0');


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

    @Override
    public String toString() {
        return "Cell{" +
                "_row=" + _row +
                ", _column=" + _column +
                ", value=" + value.token +
                '}';
    }

    public static void main(String[] args) {
        Cell cell = new Cell(0, 0, '0');
        System.out.println(cell.toString());
    }
}