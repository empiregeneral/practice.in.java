package cn.pintia.zjo.practice.problem1048;


import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @Author lei.zhu
 * @Description 背包(Bag)：是一种不支持从中删除元素的集合数据类型，
 *                        它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素，
 *                         使用背包就说明元素的处理顺序不重要，可以想象一个背包，
 *                         往里面放了N个小球，在取球的时候手伸进背包是随机取出来的，
 *                         通常这样的数据结构用来进行计算平均值等对元素顺序没有要求的算法；
 * @Date 22:19 2020/3/17
 * @Param
 * @return
 **/
public class Bag<Item> implements Iterable<Item> {
    private Bag.Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Bag.Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Bag.Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Bag.Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext()  { return current != null;                     }

        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}