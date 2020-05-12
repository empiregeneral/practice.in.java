package cn.pintia.zjo.practice.test.problem1324;

import cn.pintia.zjo.practice.problem1324.DecorateFormatted;
import io.qameta.allure.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@RunWith(JUnitParamsRunner.class)
@Epic("模拟题")
@Feature("模拟Unix ls罗列文件")
public class Problem1324Test {

    @Test
    @FileParameters(value = "src/test/resources/data_zjo_1324.csv", mapper = ListInStringMapper.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Unix ls命令测试")
    public void testFormatterList(List<String> inputList) {
        Readable readable = new DecorateFormatted(inputList).formatted();
        Scanner output = new Scanner(readable);
        while(output.hasNextLine()) {
            System.out.println(output.nextLine());
        }
    }
}
