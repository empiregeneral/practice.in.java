package cn.pintia.zjo.practice.problem2109;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;
import java.util.PriorityQueue;

public class Solution implements Readable {
    private int count = 1;
    private int totalOfBeans;

    private PriorityQueue<FoodAndBean> heap;

    private double result = 0.0;

    public Solution(List<FoodAndBean> foodAndBeanList, int totalOfBeans) {
        this.heap = new PriorityQueue<>();
        for (FoodAndBean foodAndBean : foodAndBeanList) {
            heap.add(foodAndBean);
        }

        this.totalOfBeans = totalOfBeans;
        calc();
    }

    private void calc() {
        while(!heap.isEmpty()) {
            FoodAndBean foodAndBean = heap.peek();
            int haveFood = foodAndBean.getHaveFood();
            int haveBeans = foodAndBean.getHaveBeans();
            double radio = foodAndBean.getRadio();
            if (haveBeans <= totalOfBeans) {
                totalOfBeans = totalOfBeans - haveBeans;
                result += haveFood;
            } else {
                result += totalOfBeans * radio;
                break;
            }
            heap.poll();
        }
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(String.format("%.3f", new Object[]{result}));
        return 10;
    }
}
