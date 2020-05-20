package cn.pintia.zjo.practice.test.problem1733;

import cn.pintia.zjo.practice.problem1733.CommonSubsequence;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("动态规划")
@Feature("求解两个数组的最长公共子串的长度")
@RunWith(JUnitParamsRunner.class)
public class Problem1733Test {

    @Test
    @FileParameters(value = "src/test/resources/data_zjo_1733.csv", mapper = StringMapper.class)
    public void testCommonSubsequence(String line, int expect) {
        Readable readable = new CommonSubsequence(line);
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            assertThat(Integer.parseInt(scanner.next())).isEqualTo(expect);
        }
    }
}
