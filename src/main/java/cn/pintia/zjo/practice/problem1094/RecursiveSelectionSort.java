package cn.pintia.zjo.practice.problem1094;

import java.util.Arrays;
import java.util.Random;

public class RecursiveSelectionSort {
    public static <T extends Comparable> void sort(T[] list) {
        sort(list, 0, list.length - 1);
    }

    public static <T extends Comparable> void sort(T[] list, int start, int end) {
        if (start < end) {
            // Find the smallest number and its index in lis (low...high)
            int indexOfMin = start;
            T min = list[start];
            for (int i = start + 1; i <= end; i++) {
                if (less(list[i], min)) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            // Swap the smallest in list(low .. high) with list(low)
            list[indexOfMin] = list[start];
            list[start] = min;

            sort(list, start + 1, end);
        }
    }

    private static <T extends Comparable> boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
