package cn.pintia.zjo.practice.problem1962;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
                return fibs[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static List<BigInteger> getListFromIterator(Iterator<BigInteger> iterator) {
        List<BigInteger> list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
        return list;
    }

    public static BigInteger[] getArrFromIterator(Iterator<BigInteger> iterator) {
        List<BigInteger> list = getListFromIterator(iterator);
        return list.toArray(new BigInteger[list.size()]);
    }
}
