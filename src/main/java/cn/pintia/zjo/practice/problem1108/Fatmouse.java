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


    public int getSpeed() {
        return speed;
    }
    public int getNo() {
        return no;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Fatmouse o) {
        if (this.weight != o.weight) {
            // 重量不同，按照重量从小到大排序
            return Integer.signum(this.weight - o.weight);
        } else {
            // 重量相同，速度从大到小排序
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
