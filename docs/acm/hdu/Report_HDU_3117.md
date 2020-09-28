# HDU 3117 Solved Report

## Subject 
### 题目地址

[HDU 3177](http://acm.hdu.edu.cn/showproblem.php?pid=3117)

### 题目大意

求解斐波纳济数Fn的前4位数字和后四位数字，中间的结果用"..."表示。

输入的范围Max(n) =  \$10^8\$，按照网页上测试用例输出结果显示第40位Fn数为：**63245986**，正好8位整数。超过8位数的Fn数，第64位Fn数，表示如下：

```
1023...4155
```

输入：

```
0
1
2
3
4
5
35
36
37
38
39
40
64
65
```

输出：

```
0
1
1
2
3
5
9227465
14930352
24157817
39088169
63245986
1023...4155
1061...7723
1716...7565
```



## 解题思路

如何在2000ms的事件内求导斐波纳济数，并输出正确的格式，这是一个大问题，起先想到的是用BigInteger和Dp进行推导，但是这种算法铁定要超过2000ms，因为n的数值增加，Fn的值呈指数级地增长。

解决问题要点

- 对于第40个以下的Fn数，可以用公式来推导：

  an=(1/√5)*{[(1+√5)/2]^n-[(1-√5)/2]^n}  算法时间O(1)即能求出要求的值。

- 对于第40个以上的Fn数，最理想的方法是用推导矩阵来实现，初始矩阵为

$$
M = \begin{pmatrix} 
1 & 1 \\

1 & 0 \\

\end{pmatrix}
$$

$$
F =\begin{pmatrix}
1 \\

0 \\

\end{pmatrix}
$$

​       求解公式为：
$$
R = \left(M^n F\right);
R = \begin{pmatrix} 
Fn \\

Fn-1 \\
\end{pmatrix}
$$


- 根据矩阵快速幂的推导求mod 10000，可以计算出Fn的后4位数字

- 那么如何求取Fn的前4位数字呢？来看以下算法，真是受教了！！

- ![ <a href=](https://www.programmersought.com/images/703/d9de167bc0f369a4a5effb0b24159f67.JPEG)

  

  

## 经验总结

1. 此题是数学之美的集中体现，运用数学公式的推导和计算能够在规定的时间内轻易求解该问题，如果用蛮力算法，铁定超时，另外用javaagent插件能够有效的度量出程序运行的时间，避免分析算法走的弯路。由此可见，计算机编程只是工具，数学才是解决问题的基础。

2. ISSUE：

     This method also reveals that when you want to request the first few digits of a large number, you can just ask for the decimal part below log10 and then pow it. The principle is also easy to understand. The reason why this question can be used is because fib has a general term formula, which simplifies this question in some sense.



## Hit Problems
[HDU 2604](http://acm.hdu.edu.cn/showproblem.php?pid=2604)
[HDU 1757](http://acm.hdu.edu.cn/showproblem.php?pid=1757)
[HDU 1575](http://acm.hdu.edu.cn/showproblem.php?pid=1575)

