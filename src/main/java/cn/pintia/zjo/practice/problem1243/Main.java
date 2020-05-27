package cn.pintia.zjo.practice.problem1243;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String msg = scanner.next();
                ProcessChain chain = new ProcessChain().addChain(new ProtocolProcessImp()).
                        addChain(new HostProcessImp()).
                        addChain(new PortProcessImp()).
                        addChain(new PathProcessImp());
                chain.process(msg);
                List<Readable> readables = chain.getOutputList();
                for (Readable readable : readables) {
                    Scanner output = new Scanner(readable);
                    while(output.hasNext()) {
                        System.out.println(output.nextLine());
                    }
                }
                System.out.println();
            }
        }
    }
}
