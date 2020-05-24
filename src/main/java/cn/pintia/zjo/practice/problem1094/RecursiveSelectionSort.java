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
                if (min.compareTo(list[i]) >=0 ) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            swap(min, list[start]);

            sort(list, start + 1, end);
        }
    }

    public static <T> void swap(T a, T b) {
        T tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
