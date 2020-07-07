package cn.pintia.zjo.practice.problem1951;

public class PrimePair implements Comparable<PrimePair> {
    private int firstPrime;
    private int secondPrime;
    public int distance;

    public PrimePair(int firstPrime, int secondPrime) {
        checkValidPrime(firstPrime);
        checkValidPrime(secondPrime);
        this.firstPrime = firstPrime;
        this.secondPrime = secondPrime;
        distance = Math.abs(this.firstPrime - this.secondPrime);
    }


    private boolean checkValidPrime(int num) {
        return true;
    }

    @Override
    public int compareTo(PrimePair primePair) {
        return primePair.distance -  this.distance;
    }

    @Override
    public String toString() {
        return String.format("%d = %d + %d\n", new Object[]{firstPrime + secondPrime, firstPrime, secondPrime});
    }
}
