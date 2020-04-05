package cn.pintia.zjo.practice.test.problem1324;

import cn.pintia.zjo.practice.problem1324.DecorateFormatted;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
public class Problem1324Test {

    @Test
    @FileParameters(value = "src/test/resources/data_zjo_1324.csv", mapper = ListInStringMapper.class)
    public void testFormatterList(List<String> inputList) throws FileNotFoundException {
        Readable readable = new DecorateFormatted(inputList).formatted();
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("src/test/resources/output_zjo_1324.txt", true)));
        System.setOut(out);
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            out.println(output.nextLine());
        }
        out.close();
        System.setOut(System.out);
    }
}
