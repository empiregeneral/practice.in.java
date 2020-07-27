package cn.pintia.zjo.practice.problem2136;

import cn.pintia.zjo.practice.problem1108.Fatmouse;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int testcases = input.nextInt();
        for (int testcase = 0; testcase < testcases; testcase++) {

            int capacity = input.nextInt();
            List<Integer> inputList = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                inputList.add(input.nextInt());
            }

            Readable readable = new FindLongestOrderSequenceImp(inputList);
            Scanner output = new Scanner(readable);

            if (testcase != 0) {
                System.out.println();
            }
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
