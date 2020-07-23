package cn.pintia.zjo.practice.problem1108;

public class Fatmouse implements Comparable<Fatmouse> {
    private int no;
    private int weight;
    private int speed;

    public Fatmouse(int no, int weight, int speed) {
        this.no = no;
        this.weight = weight;
        this.speed = speed;
    }

    @Override
    public int compareTo(Fatmouse o) {
        if (this.weight != o.weight) {
            return Integer.signum(this.weight - o.weight);
        } else {
            return Integer.signum( o.speed - this.speed);
        }
    }

    @Override
    public String toString() {
        return "Fatmouse{" +
                "no=" + no +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
