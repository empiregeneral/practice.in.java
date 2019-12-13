package cn.pintia.zjo.practice.problem1006;

/**
 * @ClassName: DecipherMachineImp
 * @Description: TODO
 * @Author :lei.zhu
 * @Date 2019/11/11 18:17
 * @Version 1.0
 **/
public class DecipherMachineImp implements DecipherMachine {
    private int key;
    private char[] cipherChars;
    private int[] cipherCodes;
    private int n;
    private TransformCode transformCode;

    public DecipherMachineImp(int key, String cipherText) {
        this.cipherChars = cipherText.toCharArray();
        this.key = key;
        this.n = cipherText.length();
        transformCode = new TransformCodeImp(cipherText);
        this.cipherCodes = transformCode.transformChar2Int(cipherChars);
    }

    @Override
    public int[] doTheUntwist(int key, int[] cipherCodes) {
        int[] tmpInt = new int[cipherCodes.length];
        for ( int i = 0; i < cipherCodes.length; i++) {
            tmpInt[(key * i) % n] = (cipherCodes[i] + i) % 28;
        }
        return tmpInt;
    }
}
