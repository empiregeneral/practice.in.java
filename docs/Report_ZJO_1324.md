# ZJO 1324的解题报告

## 原题内容
[ZJO_1324](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827364823)


题目大意
模拟unix终端中ls命令的输出，其中要求模拟屏幕的宽度下打印文件名列表，文件的名称的限制（其实不用去管，呵呵）为{a-zA-Z.-_}。

每个文件名以最大文件名为准向左对齐，每列输出之间隔着两个空格。

输入：
2
221d525f13f8fe4122c825a1d5a474e8f65bbda98d6f0212fd71e422fd60
dbe2fc281529420a0a5d8e28151b49ec373a0afa07c6b58cb4bd6ec36defcfa7

输出：
------------------------------------------------------------
221d525f13f8fe4122c825a1d5a474e8f65bbda98d6f0212fd71e422fd60
dbe2fc281529420a0a5d8e28151b49ec373a0afa07c6b58cb4bd6ec36defcfa7

这仅仅是一个“特殊”的测试用例，注意两行文件名的长度应该是大于等于60个字符。

题外话：通过Linux命令可以生产最多32未字符，轻易地造数据并组织测试用例：
```date +%s%N | md5sum | head -c 64
   cat /dev/urandom | head -n 10 | md5sum
```

注意最多只输出32个字符
当然可以设计shell脚本输出64位字符
```function randStr { j=0; for i in {a..z};do array[$j]=$i;j=$(($j+1));done; for i in {A..Z};do array[$j]=$i;j=$(($j+1));done; for ((i=0;i<64;i++));do strs="$strs${array[$(($RANDOM%$j))]}"; done; echo $strs; }```



## 解题思路和报告内容
1. 查看过unix ls的coreutils源代码，ls.c的代码异常复杂，你要看清楚其打印逻辑，黄花菜都凉了。
2. 题目要求是在60个字符内格式化输出文件名，输入的数据可以存储在ArrayList<String>中，后面就针对ArrayList<String>进行处理操作就可以了。
3. 避免面向过程编程，要通过Java设计的类和接口组织输出的结果。
设计思路
使用接口来封装格式化ArrayList<String>的行文
interface FormattedListInString {
    Readable formatted();
}
实际上输出的是Formatted类read函数处理的结果，注意Main函数为其总接口。

代码实现容易，Debug往往很难，但是要掌握一条原则，在设计的过程只要掌握合理的设计的思路（包含合适设计模式、数据结构），无需关心过多的输入输出的细节，这样coding的结果才高效可信。

但是该问题的Debug确实有很多坑：
1. 输出的每一行最后不存在空格，这点我一开始纠结了很久，需要查看ls的命令的结果和网上的答案才搞清楚。
   狠了一点，使用diff -c命令比较输出的结果，这上面花了不少的时间。
2. 获取输出的ROWS和COLUMNS的边界问题，有些用例容易越界。
   获取ROWS和COLUMNS的算法我还未推敲清楚，只是看着答案来编程，需要继续琢磨……

最后还需要设想一下，测试代码要怎么样设计才好。

