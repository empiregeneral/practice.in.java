package cn.pintia.zjo.practice.problem1091;

import java.util.Objects;

public class PositionInChess {
    private String position;
    private int x;
    private int y;

    public PositionInChess(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionInChess(String position) {
        assert position.length() == 2;
        this.position = position;
        init();
    }

    private void init() {
        char[] posInChar = position.toCharArray();
        this.y = (posInChar[0] - 'a');
        this.x = (posInChar[1] - '1');
    }

    public static PositionInChess transfer(String pos) {
        return new PositionInChess(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionInChess that = (PositionInChess) o;
        return x == that.x && y == that.y && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, x, y);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PositionInChess{" +
                "position='" + position + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
