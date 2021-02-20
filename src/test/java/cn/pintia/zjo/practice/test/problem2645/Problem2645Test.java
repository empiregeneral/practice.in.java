package cn.pintia.zjo.practice.test.problem2645;

import cn.pintia.zjo.practice.problem2645.IpAddressToBinaryStr;
import cn.pintia.zjo.practice.problem2645.Solution;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

@Epic("基础题")
@Feature("位运算，通过一组ip地址计算，子网掩码和一组中最小地址")
@RunWith(JUnitParamsRunner.class)
public class Problem2645Test {
    @Test
    @Parameters({"194.85.160.177 194.85.160.183 194.85.160.178,194.85.160.176\n255.255.255.248",
                 "194.85.160.130 194.85.160.133,194.85.160.128\n255.255.255.248"})
    public void testCalcNetmask(String ipList, String result) {
        Readable readable = new Solution(toStringList(ipList));
        Scanner output = new Scanner(readable);
        while(output.hasNext()) {
            Assert.assertTrue(result.contains(output.nextLine()));
        }
    }

    private List<String> toStringList(String input) {
        List<String> tmpList = new LinkedList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        while(scanner.hasNext()) {
            tmpList.add(scanner.next());
        }
        return tmpList.stream().map(IpAddressToBinaryStr::valueOf).collect(Collectors.toList());
    }
}
