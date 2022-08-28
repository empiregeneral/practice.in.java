package cn.pintia.zjo.practice.problem2109;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;
import java.util.PriorityQueue;

public class Solution implements Readable {
    private int count = 1;
    private int totalOfFood;

    private PriorityQueue<BeansAndFood> heap;

    private double result = 0.0;

    public Solution(List<BeansAndFood> myList, int totalOfFood) {
        this.heap = new PriorityQueue<>();
        for (BeansAndFood beansAndfood : myList) {
            heap.add(beansAndfood);
        }

        this.totalOfFood = totalOfFood;
        calc();
    }

    private void calc() {
        while(!heap.isEmpty()) {
            BeansAndFood beansAndFood = heap.peek();
            int foodCount = beansAndFood.getHaveFood();
            int beans = beansAndFood.getHaveBeans();
            double radio = beansAndFood.getRadio();
            if (foodCount <= totalOfFood) {
                totalOfFood = totalOfFood - foodCount;
                result += beans;
            } else {
                result += totalOfFood * radio;
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
