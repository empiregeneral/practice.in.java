package cn.pintia.zjo.practice.test.problem1092;

import cn.pintia.zjo.practice.problem1092.Queue;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

@RunWith(JUnitParamsRunner.class)
@Epic("图论题")
@Feature("队列的测试")
public class QueueTest {
    private Queue<Comparable> queue = new Queue<>();

    private Queue initQueue(Comparable[] array) {
        Queue<Comparable> queue;
        for (Comparable item : array) {
            this.queue.enqueue(item);
        }
        queue = this.queue;
        return queue;
    }

    @Parameters(method = "testData")
    @Test
    public void testEnqueue(Comparable[] array) {
        Queue<Comparable> testQueue = initQueue(array);
        int firstIndex = 0;
        Assert.assertEquals(testQueue.peek(), array[firstIndex]);
    }

    @Parameters(method = "testData")
    @Test
    public void testDisplayQueue(Comparable[] array) {
        Queue<Comparable> testQueue = initQueue(array);
        System.out.println(testQueue.toString());
    }


    @Parameters(method = "testData")
    @Test
    public void testDequeue(Comparable[] array) {
        Queue<Comparable> testQueue = initQueue(array);
        int index = 0;
        while (!testQueue.isEmpty() && index <= array.length - 1 ) {
            Assert.assertEquals(testQueue.dequeue(), array[index]);
            index++;
        }
        Assert.assertTrue(testQueue.isEmpty());
    }

    @Parameters(method = "testData")
    @Test
    public void testQueueIterator(Comparable[] array) {
        Queue<Comparable> testQueue = initQueue(array);
        Iterator<Comparable> iterator = testQueue.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            Assert.assertEquals(iterator.next(), array[index++]);
        }
    }

    private Object[] testData() {
        Comparable[] cases1 = new Comparable[]{1, 2, 3, 4, 5, 6, 7};
        Comparable[] cases2 = new Comparable[]{0.99, 0.98, 0.97, 0.96};
        return new Object[]{
                new Object[]{ cases1},
                new Object[]{ cases2}
        };
    }
}
