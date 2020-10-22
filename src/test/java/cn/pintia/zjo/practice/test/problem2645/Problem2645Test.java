package cn.pintia.zjo.practice.test.problem2645;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.util.*;

@Epic("基础题")
@Feature("位运算，通过一组ip地址计算，子网掩码和一组中最小地址")
@RunWith(JUnitParamsRunner.class)
public class Problem2645Test {
    @Test
    @Parameters({"194.85.160.177 194.85.160.183 194.85.160.178,255.255.255.248"})
    public void testCalcNetmask(String  ipAddresses, String netMask) {
        System.out.println(Arrays.toString(toStringList(ipAddresses).toArray()));

    }

    private List<String> toStringList(String input) {
        List<String> tmpList = new LinkedList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        while(scanner.hasNext()) {
            tmpList.add(scanner.next());
        }
        return tmpList;
    }
}
