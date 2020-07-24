package cn.pintia.zjo.practice.problem1962;

import java.math.BigInteger;

public enum FibonacciStrategy {
    ONE_STRATEGY() {
        @Override
        public BigInteger[] getFibTable(int n) {
            return Machine.createFibTable(n);
        }
    },

    TWO_STRATEGY() {
        @Override
        public BigInteger[] getFibTable(int n) {
            return Fibonacci.getArrFromIterator(new Fibonacci(n).iterator());
        }
    };

    public abstract BigInteger[] getFibTable(int n);
}
