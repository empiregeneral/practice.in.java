package cn.edu.hdu.acm.problem1009;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;
import java.util.PriorityQueue;

public class Solution implements Readable {
    private int count = 1;
    private PriorityQueue<Rational> heap;

    private Rational catFoodTotal;

    private Rational result = new Rational();


    public Solution(List<Rational> radioList, Rational catFoodTotal) {
        this.heap = new PriorityQueue<>();
        for (Rational rational : radioList) {
            heap.add(rational);
        }
        this.catFoodTotal = catFoodTotal;
        init();
    }

    private void init() {
        while(!heap.isEmpty()) {
            Rational radio = heap.peek();
            Rational catFood = new Rational(radio.getDenominator(), 1);
            Rational javaBean = new Rational(radio.getNumerator(), 1);
            if (catFood.compareTo(catFoodTotal) > 0) {
                catFoodTotal = catFoodTotal.subtract(catFood);
                result = result.add(javaBean);
            } else {
                result = result.add(catFoodTotal.multiply(radio));
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

        cb.append(String.format("%.3f", new Object[]{result.doubleValue()}));

        return 10;
    }
}
