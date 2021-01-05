package cn.edu.hdu.acm.problem1967;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestCase {
    Byte[] _lastWeek;
    Byte[] _thisWeek;
    int[][] _givenNumbers;

    boolean _solved;

    public TestCase(List<String> lastWeek, List<String> thisWeek) {
        _lastWeek = lastWeek.stream().map(new TransformStringsToBytes()).flatMap(Stream::of).toArray(Byte[]::new);
        _thisWeek = thisWeek.stream().map(new TransformStringsToBytes()).flatMap(Stream::of).toArray(Byte[]::new);
        _solved = false;
        _givenNumbers =new int[10][];
        generateNumbers();
    }


    public TestCase(Byte[] lastWeek, Byte[] thisWeek) {
        _lastWeek = lastWeek;
        _thisWeek = thisWeek;
        _givenNumbers = new int[10][];
        _solved = false;
        generateNumbers();
    }

    private void generateNumbers() {
        for (int j = 1; j <= 10; j++) {
            int n = 0;
            int[] temp = new int[81];

            for (int i = 0; i < 81; i++) {
                if (_thisWeek[i] == j) {
                    temp[n] = i;
                    n++;
                }
            }

            _givenNumbers[j-1] = new int[n];
            for (int i = 0; i < n; i++) {
                _givenNumbers[j-1][i] = temp[i];
            }
        }
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "_lastWeek=" + Arrays.toString(_lastWeek) +
                ", _givenNumbers=" + Arrays.deepToString(_givenNumbers) +
                ", _solved=" + _solved +
                '}';
    }

    public void TryBoard(Board candidate) {
        if (!_solved) {
            _solved = candidate.Matches(_lastWeek, _givenNumbers);
        }
    }

    public boolean IsSolved() {
        return _solved;
    }

    static class TransformStringsToBytes implements Function<String, Byte[]>{
        final int lineNo = 9;

        @Override
        public Byte[] apply(String s) {
            String regex = "(?<=[0-9])(?=([0-9])+(?![0-9]))";
            Byte[] bytes = new Byte[lineNo];
            Scanner scanner = new Scanner(new ByteArrayInputStream(s.replaceAll(regex, " ").getBytes()));
            for (int i = 0; scanner.hasNextByte(); i++) {
                bytes[i] = scanner.nextByte();
            }
            scanner.close();
            return bytes;
        }
    }
}
