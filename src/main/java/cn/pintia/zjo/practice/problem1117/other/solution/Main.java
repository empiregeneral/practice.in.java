package cn.pintia.zjo.practice.problem1117.other.solution;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String inputText = scanner.nextLine();
            if (inputText.equals("END")) {
                break;
            }
            Scanner output = new Scanner(new Solution(inputText));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}

class Solution implements Readable {
    private int count = 1;
    private char[] chars;
    private int feq = 1;

    private int codeLen = 0;

    private PriorityQueue<Integer> heap = new PriorityQueue<Integer>();


    public Solution(String text) {
        this.chars = text.toCharArray();
        Arrays.sort(chars);
        init(chars);
    }

    private void init(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                heap.add(feq);
                feq = 1;
            } else {
                feq++;
            }
        }

        heap.add(feq);
        if (heap.size() == 1) {
            codeLen += heap.peek();
        }

        while(heap.size() > 1) {
            int left = heap.peek();
            heap.poll();
            int right = heap.peek();
            heap.poll();
            heap.add( left + right);
            codeLen += (left + right);
        }
        heap.poll();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(String.format("%d %d %.1f\n", new Object[]{chars.length * 8, codeLen, (chars.length * 8.0) / codeLen}));
        return 0;
    }
}
