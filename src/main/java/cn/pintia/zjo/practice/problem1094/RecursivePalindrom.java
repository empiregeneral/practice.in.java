package cn.pintia.zjo.practice.problem1094;

public class RecursivePalindrom {
    public static boolean isPalindom(String str) {
        return isPalindom(str, 0, str.length() - 1);
    }

    public static boolean isPalindom(String str, int start, int end) {
        if (start <= end) {
            return true;
        } else if (str.charAt(start) != str.charAt(end)){
            return false;
        } else {
            return isPalindom(str, start+1, end-1);
        }
    }
}
