# ZJO 1324 Solved Report

## Subject
[Unix ls](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827364823)


题目大意
模拟unix终端中ls命令的输出，其中要求模拟屏幕的宽度下打印文件名列表，文件的名称的限制为字符集{a-zA-Z.-_}。

每个文件名以最大文件名为准向左对齐，每列输出的文件名之间隔着两个空格。


输入：
```
2
221d525f13f8fe4122c825a1d5a474e8f65bbda98d6f0212fd71e422fd60
dbe2fc281529420a0a5d8e28151b49ec373a0afa07c6b58cb4bd6ec36defcfa7
```

输出：
```
------------------------------------------------------------
221d525f13f8fe4122c825a1d5a474e8f65bbda98d6f0212fd71e422fd60
dbe2fc281529420a0a5d8e28151b49ec373a0afa07c6b58cb4bd6ec36defcfa7
```

一条“特殊”的测试用例，与网页上的不同，其包含的文件名的长度是大于等于60个字符的。

在Linux终端中，通过输入的命令和编写shell脚本，可以一步得出60个以上字符的文件名。
```
date +%s%N | md5sum | head -c 64 （32个字符）
cat /dev/urandom | head -n 10 | md5sum （32个字符）
```

```
function randStr { 
            j=0; 
            for i in {a..z};do array[$j]=$i;j=$(($j+1));done; 
            for i in {A..Z};do array[$j]=$i;j=$(($j+1));done; 
            for ((i=0;i<64;i++)); 
            do 
                strs="$strs${array[$(($RANDOM%$j))]}"; 
            done; 
            echo $strs; }
```


## 解题思路
解题思路：
1. 查看过unix ls的coreutils源代码，ls.c的代码异常复杂，等到看清楚其打印逻辑，黄花菜都凉了。
2. 输入的数据可以存储在```ArrayList<String>```中，设计的类Formatted和接口都是围绕其做格式化处理。
3. 看着Cpp编写的“正确的代码“会非常的难受，如果使用面向接口编程，通过接口来封装算法实现的关键方法，这样读起来会清晰很多。
4. 输出的结果如果装饰器模式来修饰就会更加清晰。

编程注意点：
1. 输入超过60个字符的文件名如何，结果应该还是要按需打印的。
2. 每一行最后的文件名后面不能有空格输出。如果肉眼能看不出结果，可以使用diff -c命令来分析。
3. 考虑输出个数组列表index值超出ArrayList<String>长度的处理。

设计思路：
1. 使用接口来封装格式化文件名的列表
```
interface FormattedListInString {
    Readable formatted();
}
```
2. 输出的是Formatted类中处理List中字符串的结果，Main类是负责处理输入和得出最终的输出。
3. 通过装饰器DecorateFormatted来修饰Formatted类的最终输出结果。

代码提交和Debug的经过：

第一次提交PE，说明答案基本正确，而输入的格式有误。

通过diff命令和网上的标准答案比对，查出是行尾的输出空格错误，用了正则表达式去除行尾的空格，即可AC。

总结经验和教训，先不要纠缠于Debug的细节，掌握其顶层设计，提交代码之后发现错误，再一步步排查细节问题即可。

遇到的坑：
1. 输出的每一行最后是不能存在空格的，这一点要牢记。
2. 获取输出的ROWS和COLUMNS的边界问题，第3组用例容易出现输出结果越界的问题。
   获取ROWS和COLUMNS的算法我还未推敲清楚，只是看着答案来编程，需要继续琢磨……

## 经验总结
问题1：最后要编写测试代码，需要怎么样设计，是否可以在程序之初就编写好了测试代码，来严谨测试程序？
可能的答案： 使用proxy代理反馈interface的结果？

问题2： 测试代码具体要怎么设计才合理，尤其这种复杂的输入和输出格式？
可能的答案： JUnitParams框架中@FileParameters的使用…… 

编写了一个粗糙的例程，ListInStringMapper.class适配器是运行该测试方法的核心。
```
    @Test
    @FileParameters(value = "src/test/resources/test_1324.csv", mapper = ListInStringMapper.class)
    public void testFormattedListInString(List<String> inputList) throws FileNotFoundException {
        Readable readable = new FormattedListInStringImp(inputList).formatted();
        Scanner input = new Scanner(readable);
        Scanner output = new Scanner(new FileInputStream("C:\\github\\jmeter-http-request-sample\\src\\test\\resources\\output_1324.txt"));
        while(input.hasNextLine() && output.hasNextLine()) {
            Assert.assertEquals(input.nextLine().replaceAll("[　*| *| *|//s*]*$", ""), output.nextLine());
        }
    }
```

## Hit Problems
[Formate text](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827364646)

