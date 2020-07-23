package cn.pintia.zjo.practice.problem1962;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;

public class Fib {
    public static void main (String[] arg) throws Exception
    {
        StreamTokenizer st = new StreamTokenizer (new BufferedReader(
                new InputStreamReader(new BufferedInputStream(System.in))));
        st.ordinaryChars ('-', '9');
        st.wordChars ('-', '9');

        // precalculate enough fibs
        BigInteger f[] = new BigInteger[512];
        f[0] = new BigInteger ("1");
        f[1] = new BigInteger ("2");
        for (int i=2 ; i<512 ; i++) {
            f[i] = f[i-2].add (f[i-1]);
        }


        while (true)
        {
            // read lower and upper bounds
            st.nextToken(); BigInteger lower = new BigInteger (st.sval);
            st.nextToken(); BigInteger upper = new BigInteger (st.sval);
            if (upper.signum() == 0) {
                break;
            }

            // search lower and upper bounds
            int ilower = 0, iupper = 0;
            while (lower.compareTo (f[ilower]) > 0) {
                ++ilower;
            }
            while (upper.compareTo (f[iupper]) >= 0) {
                ++iupper;
            }
            System.out.println (iupper-ilower);
        }
    }
}
