package cn.pintia.zjo.practice.problem1093;

public class Box implements Comparable<Box> {

    private int length;
    private int width;
    private int height;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Box box) {
        return (box.length - this.length);
    }

    @Override
    public String toString() {
        return "Box[" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ']';
    }
}
