package cn.pintia.zjo.practice.problem1117;

import java.util.LinkedList;
import java.util.List;

public class LetterFrequency {
    private static int[] countLetter(String text) {
        int[] count = new int[31];

        for ( int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if ((character >= 'A') && (character <= '_')) {
                count[character - 'A']++;
            }
        }

        return count;
    }

    public static Integer[] frequencyList(String text) {
        int[] count = countLetter(text);
        List<Integer> integerList = new LinkedList<>();
        for (int item : count) {
            if (item == 0) {
                continue;
            }
            integerList.add(item);
        }
        return integerList.toArray(new Integer[0]);
    }

}
