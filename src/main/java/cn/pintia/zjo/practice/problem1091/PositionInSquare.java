package cn.pintia.zjo.practice.problem1091;

import java.util.Objects;

public class PositionInSquare {
    private String position;
    private int x;
    private int y;
    private int step;

    public PositionInSquare() {

    }

    public PositionInSquare(String position) {
        assert position.length() == 2;
        this.position = position;
        init();
    }

    private void init() {
        char[] posInChar = position.toCharArray();
        this.x = posInChar[0] - 'a';
        this.y = posInChar[1] - '1';
        this.step = 0;
    }

    public static PositionInSquare transfer(String from) {
        return new PositionInSquare(from);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionInSquare that = (PositionInSquare) o;
        return x == that.x && y == that.y && step == that.step && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, x, y, step);
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
