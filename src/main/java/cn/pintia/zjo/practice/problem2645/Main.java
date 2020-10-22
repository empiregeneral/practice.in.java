package cn.pintia.zjo.practice.problem2645;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Administrator
 * @Description Ip networks 通过位运算求取，ip address的范围
 * Input:
 */
public class Main {
    public static void main(String[] args)  {
        // read input
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int m = in.nextInt();
        if (m < 1 || m > 1000) {
            throw new IllegalArgumentException("m is out of range");
        }
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            String s = in.next();
            int addr = 0;
            StringTokenizer st = new StringTokenizer(s, ".");
            for (int j = 0; j < 4; j++) {
                String t = st.nextToken();
                if (t.length() == 0 || t.length() > 1 && t.charAt(0) == '0') {
                    throw new IllegalArgumentException("invalid ip number");
                }
                int ti = Integer.parseInt(t);
                if (ti < 0 || ti > 255) {
                    throw new IllegalArgumentException("invalid ip number");
                }
                addr <<= 8;
                addr |= ti;
            }
            a[i] = addr;
            if (st.hasMoreTokens()) {
                throw new IllegalArgumentException("invalid ip");
            }
        }
        if (in.hasNext()) {
            throw new IllegalArgumentException("extra data in file");
        }
        in.close();

        // solve
        int n = 0;
        for (int i = 1; i < m; i++) {
            n = Math.max(n, 32 - Integer.numberOfLeadingZeros(a[i - 1] ^ a[i]));
        }
        int mask = n == 32 ? 0 : -1 << n;

        // write output
        PrintWriter out = new PrintWriter(System.out);
        out.println(format(a[0] & mask));
        out.println(format(mask));
        out.close();
    }

    static String format(int addr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                sb.append('.');
            }
            sb.append((addr >>> ((3 - i) * 8)) & 255);
        }
        return sb.toString();
    }
}
