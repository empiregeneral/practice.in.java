package cn.pintia.zjo.practice.problem1108;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int no = 1;
        List<Fatmouse> myList = new ArrayList<>();
        while(input.hasNextLine()) {
            int weight = Integer.parseInt(input.next());
            int speed = Integer.parseInt(input.next());
            myList.add(new Fatmouse(no, weight, speed));
            ++no;
        }
        Collections.sort(myList);

        for (Fatmouse fatmouse : myList) {
            System.out.println(fatmouse.toString());
        }

    }
}
