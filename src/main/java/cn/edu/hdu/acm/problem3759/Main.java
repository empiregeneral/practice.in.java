package cn.edu.hdu.acm.problem3759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Description
 * @Author lei.zhu
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = reader.readLine()) != null) {
            IHandScore iHandScore = new ReadFromLine(line);
            int handScore = iHandScore.hand();
            System.err.println(handScore);
            Scanner output = new Scanner(new Solvable(handScore));
            while(output.hasNext()) {
                System.out.println(output.next());
            }
        }

        reader.close();
    }
}
