package cn.pintia.zjo.practice.problem1962;


import java.math.BigInteger;
import java.util.Iterator;

public class Fibonacci extends FibGenerate implements Iterable<BigInteger> {
    private int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return new Iterator<BigInteger>() {
            int index = 0;
            BigInteger[] fibs = Fibonacci.this.createTable();

            @Override
            public boolean hasNext() {
                return index < n;
            }

            @Override
            public BigInteger next() {
                ++index;
                return fibs[index];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for(BigInteger item : new Fibonacci(10)) {
            System.out.println(item.toString());
        }
    }
}
