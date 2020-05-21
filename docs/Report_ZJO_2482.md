# ZJO 2482 Solved Report

## Subject
[IP Address](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827365981)

题目大意：
将32位的二进制串改为可读的IP Address。

陷阱在于
1.故意给出2进制转10进制的算法，让程序员去模拟，这样搞有不小风险超时。
答案中个位数十位数百位数是分别独立的，格式要当心。

## 解题思路
1.通过正则表达式的环视功能在32位01串中插入"."串。
在Java语言中核心的正则表达式为:
```

```
2. 

## 经验总结

## Hit Problems