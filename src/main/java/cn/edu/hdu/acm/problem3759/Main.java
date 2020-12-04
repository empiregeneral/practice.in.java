package cn.edu.hdu.acm.problem3759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = reader.readLine()) != null) {
            IHandScore iHandScore = new ReadFromLine(line);
            System.out.println(iHandScore.hand());

        }
    }
}
