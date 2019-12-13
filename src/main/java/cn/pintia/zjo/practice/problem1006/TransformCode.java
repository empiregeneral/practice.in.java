package cn.pintia.zjo.practice.problem1006;

/**
 * @ClassName: TransformCipherCode
 * @Description: 为密文，明文解码和编码操作
 * @Author :lei.zhu
 * @Date 2019/11/11 16:33
 * @Version 1.0
 **/
public interface TransformCode {
    int[] transformChar2Int(char[] chars);
    char[] transformInt2Char(int[] arr);
}
