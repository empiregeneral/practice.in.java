package cn.pintia.zjo.practice.problem2109;


public class BeansAndFood implements Comparable<BeansAndFood> {


    private int haveBeans;


    private int haveFood;

    private double radio;

    public BeansAndFood(int haveBeans, int haveFood) {
        this.haveBeans = haveBeans;
        this.haveFood = haveFood;
        radio = 1.0 * haveBeans / haveFood;

    }


    public int getHaveFood() {
        return haveFood;
    }

    public int getHaveBeans() {
        return haveBeans;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public int compareTo(BeansAndFood o) {
        if (o.radio - this.radio > 0.0) {
            return 1;
        } else if (o.radio - this.radio < 0.0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "BeansAndFood{" +
                "haveBeans=" + haveBeans +
                ", haveFood=" + haveFood +
                ", radio=" + radio +
                '}';
    }
}
