package cn.pintia.zjo.practice.problem1093;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        int caseNo = 0;
        while(input.hasNext()) {
            int capacity = input.nextInt();
            if (capacity == 0) {
                break;
            }
            List<OrientedBox> orientedBoxes = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                int z = input.nextInt();
                orientedBoxes.add(new OrientedBox(x, y, z));
            }
            caseNo++;
            Readable readable = new CalcBabylonHeight(orientedBoxes, caseNo);
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
