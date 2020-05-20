package cn.pintia.zjo.practice.test.problem1092;

import cn.pintia.zjo.practice.problem1058.DirectedEdge;
import cn.pintia.zjo.practice.problem1092.Bag;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

@Epic("图论题")
@Feature("测试背包数组")
@RunWith(JUnitParamsRunner.class)
public class BagTest<T> {
    private Bag<T> bag = new Bag<T>();

    private void initBag(T[] arr) {
        for (T item: arr) {
            bag.add(item);
        }
    }

    @Parameters(method = "testData")
    @Test
    public void testBagAdd(T[] arr) {
        initBag(arr);
        Iterator<T> iterator = bag.iterator();
        int index = arr.length - 1;
        while(iterator.hasNext() && index >=0) {
            Assert.assertEquals(iterator.next(), arr[index]);
            index = index - 1;
        }
    }

    private Object[] testData() {
        Comparable[] cases1 = new Comparable[]{1, 2, 3, 4, 5, 6, 7};
        Comparable[] cases2 = new Comparable[]{0.99, 0.98, 0.97, 0.96};
        DirectedEdge[] cases3 = new DirectedEdge[]{new DirectedEdge(1, 2, 0.95), new DirectedEdge(2, 1, 1.05)};
        return new Object[]{
                new Object[]{ cases1},
                new Object[]{ cases2},
                new Object[]{ cases3}
        };
    }
}
