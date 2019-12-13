package cn.pintia.zjo.practice.problem1006;

/**
 * @ClassName: DecipherFacade
 * @Description: 解密算法的外观模式实现
 * @Author :lei.zhu
 * @Date 2019/11/11 16:34
 * @Version 1.0
 **/
public class DecipherFacade {
    private TransformCode transformCode;
    private DecipherMachine machine;

    public DecipherFacade(DecipherMachine machine, TransformCode transformCode) {
        this.machine = machine;
        this.transformCode = transformCode;
    }

    public String decipher(int key, String cipherText) {
        /* 第一步，密文编码为codes */
        int[] cipherCodes = transformCode.transformChar2Int(cipherText.toCharArray());
        /* 第二步，根据codes和key进行破解 */
        int[] plainCodes = machine.doTheUntwist(key, cipherCodes);
        /* 将plainCodes转换为plainChars最终变成明文 */
        char[] plainChars = transformCode.transformInt2Char(plainCodes);
        return String.valueOf(plainChars);
    }

    public static void main(String[] args) {
        DecipherFacade facade = new DecipherFacade(new DecipherMachineImp(5, "cs."), new TransformCodeImp("cs."));
        System.out.println(facade.decipher(5, "cs."));
    }
}
