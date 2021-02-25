package cn.pintia.zjo.practice.problem2737;

import edu.princeton.cs.algs4.SuffixArray;


public class Main {
    public static void main(String[] args) {
        String src = "abcd";
        SuffixArray suffixArray = new SuffixArray(src);
        System.out.println(suffixArray.select(3));
    }
}
