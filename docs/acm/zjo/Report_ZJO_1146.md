# ZJO 1146的解题报告

## 原题内容

[ZJO_1146](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827364645)

LCD Display，主要考验是输出能力，类似的问题有
[MisLED](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827365693)可以相互参考设计。

## 解题报告
解题思路：

7段数字管可参见如下图：

![img](https://images.ptausercontent.com/0000%2F2194%2Fp1.gif)

安装二维char**[][]**数字的输出可以表示如下：

数字“8"，可以使用char[2][3]

|      | _    |      |
| ---- | ---- | ---- |
| \|   |      | \|   |
|      | _    |      |
| \|   |      | \|   |
|      | _    |      |



1. 先从最小的规模为1，数字'8'的输出开始模拟。
char[0][1] = '-'  // PartA
char[1][0] = '|'  // PartB
char[1][2] = '|'  // PartC
char[2][1] = '-'  // PartD
char[3][0] = '|'  // PartE
char[3][2] = '|'  // PartF
char[4][1] = '-'  // PartG
  
2. 根据scale输入的值对二极管的各个部位进行延伸扩展
如partA定义为：
```
private void drawPartA(boolean draw, int xStart, int yStart) {
           if (draw) {
               for (int i = 1; i <= scale; i++) {
                   out[xStart][yStart++] = '-';
               }
           }
       }
```
 
3. 7个二极管发光的状态可以使用二维数组LCD表示，根据要显示的数字获取其状态：
```
boolean[][] lcd = {
            /* 0 */
            {true,  true, true, true, true, true, false},
            /* 1 */
            {false, true, true, false, false, false, false},
            /* 2 */
            {true, true, false, true, true, false, true},
            /* 3 */
            {true, true, true, true, false, false, true},
            /* 4 */
            {false, true, true, false, false, true, true},
            /* 5 */
            {true, false, true, true, false, true, true},
            /* 6 */
            {true, false, true, true, true, true, true},
            /* 7 */
            {true, true, true, false, false, false, false},
            /* 8 */
            {true, true, true, true, true, true, true},
            /* 9 */
            {true, true, true, true, false, true, true}
    }
```

## 经验总结
1. 模拟题先从最小的规模进行模拟，然后再扩展成最大的规模。
2. Readable接口中int read(CharBuffer cb)方法CharBuffer的BufferSize只有1024，模拟题输出是肯定超过这个范围，这个要注意。
3. 找到规律后，需要反复调试推导正确性，这点Debug的时间话费不少。

题后思考：
1. 运用设计模式，变得可测试，运用何种设计模式较好？

## Hit Problem
[MisLED](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827365693)
