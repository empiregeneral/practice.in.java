package cn.pintia.zjo.practice.problem2109;


public class FoodAndBean implements Comparable<FoodAndBean> {

    private int haveFood;

    private int haveBeans;

    private double radio;

    public FoodAndBean(int haveFood, int haveBeans) {
        this.haveFood = haveFood;
        this.haveBeans = haveBeans;
        radio = 1.0 * haveFood / haveBeans;
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
    public int compareTo(FoodAndBean o) {
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
        return "FoodAndBean{" +
                "haveFood=" + haveFood +
                ", haveBeans=" + haveBeans +
                ", radio=" + radio +
                '}';
    }
}
