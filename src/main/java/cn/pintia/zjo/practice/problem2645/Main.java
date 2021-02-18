package cn.pintia.zjo.practice.problem2645;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * @Description Ip networks 通过位运算求取，ip address的范围
 * Input:
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNext()) {
            int n = input.nextInt();
            List<String> ipAddresses = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ipAddresses.add(input.next());
            }
            List<String> addresses = IpAddressToBinaryStr.valueOf(ipAddresses);
            Readable readable = new Solution(addresses);
            Scanner output = new Scanner(readable);
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }
    }
}
