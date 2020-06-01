package cn.pintia.zjo.practice.problem1243;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                String msg = scanner.next();
                ProcessChain chain = new ProcessChain().addChain(new ProtocolProcessImp()).
                        addChain(new HostProcessImp()).
                        addChain(new PortProcessImp()).
                        addChain(new PathProcessImp());
                chain.process(msg);
                System.out.println("URL #" +i);
                List<Readable> readables = chain.getOutputList();
                for (Readable readable : readables) {
                    Scanner output = new Scanner(readable);
                    while(output.hasNext()) {
                        System.out.println(output.nextLine());
                    }
                }
                if (i!=n) {
                    System.out.println();
                }
            }
        }
    }
}
