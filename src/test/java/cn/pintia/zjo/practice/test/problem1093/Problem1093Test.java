package cn.pintia.zjo.practice.test.problem1093;

import cn.pintia.zjo.practice.problem1093.BabylonHeight;
import cn.pintia.zjo.practice.problem1093.Box;
import cn.pintia.zjo.practice.problem1093.OrientedBox;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
@Epic("动态规划")
@Feature("求解给定的长、宽、高的盒子所能堆砌的最大高度")
public class Problem1093Test {

    @Test
    @FileParameters(value = "src/test/resources/data_zjo_1093.csv", mapper = ListOfBoxMapper.class)
    @DisplayName("用动态规划算法实现巴比伦塔的高度问题")
    @Description("测试巴比伦塔的高度")
    public void testCalcBabylonHeight(List<Box> blocks, int height) {
        Assert.assertEquals(BabylonHeight.height(blocks), height);
    }
}
