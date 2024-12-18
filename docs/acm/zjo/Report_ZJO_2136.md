# ZJO 2136 Solved Report

## Subject

题目大意，求解输入序列的递增子序列的最大长度，即动态规划（DP）中经典问题，求取最大递增子序列。

输入:
```
1 3 2 9 8 4 3
```

输出:
```
3
```

## 解题思路

根据算法教材中最长递增子序列的状态方程推导：
$$
MaxLen({a_i})= \begin{cases} \ 1,i=1\\ MaxLen({a_j}) + 1, {a_j} < {a_i}\end{cases}
$$
有了此推导方程就可以写出该算法的核心代码：

```
有a[N]和B[N]两个数组
for (int i = 0; i < capacity; i++) {
    int maxLen = 0;
    for (int j = 0; j < i; j++) {
        if ((b[j] < a[i]) && maxLen < b[j]) {
           maxLen = b[j]
        }
        b[i] = maxLen + 1;
    }
}
```



## 经验总结

这题是非常简单的动态规划实现过程，仅仅实现求出最大子序列的值即可，现实情况下通过动态规划思想处理的问题要比这个问题复杂的多。

其推导公式的出处，需要进一步挖掘出来。



## Hit Problems

