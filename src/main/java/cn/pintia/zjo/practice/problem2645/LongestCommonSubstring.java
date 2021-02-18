package cn.pintia.zjo.practice.problem2645;


public class LongestCommonSubstring {
    public static String lcs(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int[][] result = new int[a.length + 1][b.length + 1];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[i + 1][j + 1] = result[i][j] + 1;
                    max = Math.max(max, result[i + 1][j + 1]);
                }
            }
        }
        return max == 0 ? "" :s.substring(0, max);
    }
}
