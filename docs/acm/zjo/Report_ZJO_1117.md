# ZJO 1117 Solved Report

## Subject
Huffman 树的应用，题意如下，输入一串文本，比对传统的ASCII编码和huffman编码的压缩比
输入格式：
```
AAAAABCD
THE_CAT_IN_THE_HAT
END #遇到END主动结束
```

输出格式:
```
64 13 4.9
144 51 2.8
```


## 解题思路
1. 构建huffman树直接求解 （Java，运行结果 Accepted	162ms	19976 KB）-- 空间消耗巨大，设计复杂
2. 利用优先级队列求解 (C++, 运行结果 Accepted 4ms 440KB) (Java运行结果 	Accepted 121ms 20008 KB) -- 空间消耗合理，设计简约
3. 设计测试用例要考虑到极端的边界值 （Case #1: 26个A，Case #2:26个大写字母,Case #3: 一个大写字母A）

解法1：
利用优先队列构建最小堆，用huffman树的思想求解吗求解，原题答案C++版本
补充huffman树构建思想为通过贪婪算法进行局部最优解。以{'B':1, 'C':1, 'D':1, 'A':5}看这个树是如何构建的：
Step 1: 'B' 和 'C' 权值最小构建一个树 T1，权重为2 
Step 2: 'D' 和 'T1' 权重最小构建一个树 T2，权重为3
Step 3: 'T2' 和 'A' 权重最小构建一个树 T3，权重为8

将树T1、T2、T3的权值相加即为编码长度13

解法2:
直接用BinaryNode进行模拟


```
#include<iostream>
#include<queue>
#include<string>
#include<algorithm>
#include<cstdio>
using namespace std;

int main()
{
    string s;
    while(cin >> s && s != "END"){
        int cnt = 1,len = 0;
        priority_queue<int,vector<int>,greater<int> > heap;
        sort(s.begin(),s.end());
        int l = s.size();

        for(int i = 1;i < l;i ++){
            if(s[i] != s[i - 1]){
               heap.push(cnt);
               cnt = 1;
            }
            else cnt ++;
        }

        heap.push(cnt);
        if(heap.size() == 1) len += heap.top();

        while (heap.size() > 1){
            int a = heap.top();heap.pop();
            int b = heap.top();heap.pop();
            heap.push(a + b);
            len += (a + b);
        }
        heap.pop();

        printf("%d %d %.1f\n",l * 8,len,(l * 8.0) / len);
    }
    return 0;
}
```

改造后Java版的答案
```
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String inputText = scanner.nextLine();
            if (inputText.equals("END")) {
                break;
            }
            Scanner output = new Scanner(new Solution(inputText));
            while(output.hasNextLine()) {
                System.out.println(output.nextLine());
            }
        }
    }
}

class Solution implements Readable {
    private int count = 1;
    private char[] chars;
    private int feq = 1;

    private int codeLen = 0;

    private PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });


    public Solution(String text) {
        this.chars = text.toCharArray();
        Arrays.sort(chars);
        init(chars);
    }

    private void init(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                heap.add(feq);
                feq = 1;
            } else {
                feq++;
            }
        }

        heap.add(feq);
        if (heap.size() == 1) {
            codeLen += heap.peek();
        }

        while(heap.size() > 1) {
            int left = heap.peek();
            heap.poll();
            int right = heap.peek();
            heap.poll();
            heap.add( left + right);
            codeLen += (left + right);
        }
        heap.poll();
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(String.format("%d %d %.1f\n", new Object[]{chars.length * 8, codeLen, (chars.length * 8.0) / codeLen}));
        return 0;
    }
}

```
拿出例子AAAAABCD
构建huffman树，其实难点在于求解的是编码后的最大字符串长度
手工生成树如下：
```mermaid
graph TB:
8((8))-->3((3))
8((8))-->5((5))
3((3))-->1((1))
3((3))-->2((2))
2((2))-->1((1))
2((2))-->1((1))
```
编码的长度为各个叶子节点的权值（fequency）

## 经验总结

## Hit Problems
[Problem Source][http://acmgnyr.org/year2000/problems/problemf.pdf]
[Test Cases] [http://acmgnyr.org/year2000/problems/problemf.in]