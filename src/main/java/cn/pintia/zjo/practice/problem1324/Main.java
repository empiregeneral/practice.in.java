package cn.pintia.zjo.practice.problem1324;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            int capacity = scanner.nextInt();
            List<String> inputList = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                inputList.add(scanner.next());
            }
            Readable readable = new FormattedListInStringImp(inputList).formatted();
            Scanner output = new Scanner(readable);
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}
