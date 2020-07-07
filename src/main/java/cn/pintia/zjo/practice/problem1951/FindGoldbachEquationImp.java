package cn.pintia.zjo.practice.problem1951;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindGoldbachEquationImp implements GoldbachConjecture, Readable{
    private int evenNumGreaterThanSix;
    private final int lessNum = 6;
    private final int baseEvenNum = 2;
    private int count = 1;
    private int[] primeArr;
    private List<PrimePair> primePairs;

    public FindGoldbachEquationImp(int number) throws Exception {
        if ((number <= lessNum) && (number % baseEvenNum != 0)) {
            throw new Exception("The input number must greater equal by 6 and even number.");
        }
        this.evenNumGreaterThanSix = number;
        this.primeArr = SieveOfEratosthenes.listOfPrimes(evenNumGreaterThanSix);
        primePairs = FindPrimePairs(this.evenNumGreaterThanSix);
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        Collections.sort(primePairs);
        primePairs = this.FindPrimePairs(evenNumGreaterThanSix);
        cb.append(primePairs.get(0).toString());

        return 10;
    }

    @Override
    public List<PrimePair> FindPrimePairs(int num) {
        List<PrimePair> primePairs = new LinkedList<>();
        for (int i = 1; i < primeArr.length - 1; i++) {
            int key = Arrays.binarySearch(primeArr, num - primeArr[i]);
            if (key > 0) {
                PrimePair primePair = new PrimePair(primeArr[i], primeArr[key]);
                primePairs.add(primePair);
            }
        }
        return primePairs;
    }
}
