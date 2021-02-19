package cn.edu.hdu.acm.problem1967;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntFunction;
import java.util.regex.Pattern;

public class TestCase {
    byte[] _lastWeek;
    int[][] _givenNumbers;

    boolean _solved;

    public TestCase(String inputLine) {

    }

    public TestCase(byte[] lastWeek, byte[] thisSudoku) {
        _lastWeek = lastWeek;
        _givenNumbers = new int[10][];
        _solved = false;

        for (int j=1; j<=10; j++) {
            int n = 0;
            int[] temp = new int[81];

            for (int i=0; i<81; i++) {
                if (thisSudoku[i]==j) {
                    temp[n]=i;
                    n++;
                }
            }

            _givenNumbers[j-1] = new int[n];
            for(int i=0; i<n; i++)
            {
                _givenNumbers[j-1][i]=temp[i];
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> lastWeekLines = new ArrayList<>();
        List<String> thisSudukoLines = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String inputLine = br.readLine();
            lastWeekLines.add(inputLine);
        }

        for (int j = 0; j < 9; j++) {
            String inputLine = br.readLine();
            thisSudukoLines.add(inputLine);
        }

        br.close();

    }

    private static Byte[] transformLine2Bytes(String inputLine) {
        List<Byte> byteList = new LinkedList<>();
        String regex = "(?<=[0-9])(?=([0-9])+(?![0-9]))";
        Scanner scanner = new Scanner(new ByteArrayInputStream(inputLine.replaceAll(regex, " ").getBytes()));
        for (;scanner.hasNextByte();) {
            byteList.add(scanner.nextByte());
        }
        scanner.close();

        Byte[] tmpBytes = new Byte[byteList.size()];
        return byteList.toArray(tmpBytes);
    }

    private static class TransformLinesToBytes {
        Byte[] bytes = new Byte[81];
        List<Byte[]> bytesList = new LinkedList<>();

        public TransformLinesToBytes(List<String> inputLines) {
            for (String inputLine : inputLines) {
                bytesList.add(transformLine2Bytes(inputLine));
            }
        }
    }
}
