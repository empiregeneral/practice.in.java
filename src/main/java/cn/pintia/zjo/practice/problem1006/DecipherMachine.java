package cn.pintia.zjo.practice.problem1006;

/**
 * @ClassName: DecipherMachine
 * @Description: zjo 1006 使用门面模式重写该问题的解码和解密的过程
 * 接口为解密机包含一个方法即解密操作。
 * @Author :lei.zhu
 * @Date 2019/11/11 16:26
 * @Version 1.0
 **/
public interface DecipherMachine {
    /**
     * 解密操作，需要输入key和cipherCodes
     * @Param key 解密的主要参数
     * @Param cipherCodes 加密的字符编码集合
     * @return int[]
     **/
    int[] doTheUntwist(int key, int[] cipherCodes);
}
