# ZJO 1324的解题报告

## 原题内容
[ZJO_1324](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827364823)

题目大意
模拟unix终端中ls命令的输出，其中要求模拟屏幕的宽度下打印文件名列表，文件的名称的限制（其实不用去管，呵呵）为{a-zA-Z.-_}。
输入为：
2
221d525f13f8fe4122c825a1d5a474e8f65bbda98d6f0212fd71e422fd60
dbe2fc281529420a0a5d8e28151b49ec373a0afa07c6b58cb4bd6ec36defcfa7
应该为：
------------------------------------------------------------
221d525f13f8fe4122c825a1d5a474e8f65bbda98d6f0212fd71e422fd60
dbe2fc281529420a0a5d8e28151b49ec373a0afa07c6b58cb4bd6ec36defcfa7
这仅仅是一个“特殊”的测试用例，注意两行文件名的长度应该是大于等于60个字符。

题外话：通过Linux命令可以生产最多32未字符，轻易地造数据并组织测试用例：




## 解题思路和报告内容
1. 查看过unix ls的coreutils源代码，ls.c的代码异常复杂，你要看清楚其打印逻辑，黄花菜都凉了。
2. 题目要求是在60个字符内格式化输出文件名，输入的数据可以存储在ArrayList<String>中，后面就针对ArrayList<String>进行处理操作就可以了。
3. 避免面向过程编程，要通过Java设计的类和接口组织输出的结果。
具体使用步骤
使用接口来封装
interface FormattedListInString {
    Readable formatted();
}
