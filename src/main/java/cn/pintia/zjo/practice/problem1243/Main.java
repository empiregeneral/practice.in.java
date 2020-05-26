package cn.pintia.zjo.practice.problem1243;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Pattern pattern = Pattern.compile("([A-Za-z]+):");

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String msg = "http://www.baidu.com";
        ProcessChain chain = new ProcessChain().addChain(new ProtocolProcessImp());
        Readable readable = chain.process(msg, pattern);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

    }
}
