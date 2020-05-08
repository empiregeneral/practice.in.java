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

    @Override
    public int compareTo(Box box) {
        return (this.height - box.height);
    }

    public static void main(String[] args) {

    }
}
