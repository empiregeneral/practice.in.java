package cn.pintia.zjo.practice.test.problem1111;

import java.util.Random;

public class Shuffle {

    // A Function to generate a random permutation of arr[]
    public static <T> void randomize(T[] arr, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = i + random.nextInt(52-i);
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
