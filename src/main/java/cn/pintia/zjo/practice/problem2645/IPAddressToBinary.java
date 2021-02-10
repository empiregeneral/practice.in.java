package cn.pintia.zjo.practice.problem2645;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class IPAddressToBinary {
    private String address;
    private String binaryAddress;
    private List<String> addressList;

    public IPAddressToBinary(String address) {
        this.address = address;
        this.binaryAddress = transform(this.address);
    }

    public IPAddressToBinary(List<String> addressList) {
        this.addressList = addressList.stream().map(e -> transform(e)).collect(Collectors.toList());
    }


    private String transform(String originAddress) {
        String[] split = originAddress.split("[.]");
        BigInteger tmp = new BigInteger("0", 2);

        for (int shitBit = 24; shitBit >=0; shitBit -= 8) {
            BigInteger i = new BigInteger(split[(32-shitBit) / 8 - 1]);
            BigInteger C = i.shiftLeft(shitBit);
            tmp = C.or(tmp);
        }

        return tmp.toString(2);
    }

    public static String valueOf(String originAddress) {
        return new IPAddressToBinary(originAddress).binaryAddress;
    }

    public static List<String> valueOf(List<String> addresses) {
        return new IPAddressToBinary(addresses).addressList;
    }

    public static void main(String[] args) {
        String ipAddress = IPAddressToBinary.valueOf("194.85.160.177");
        System.out.println(ipAddress);

        List<String> addresses = IPAddressToBinary.valueOf(List.of("192.85.160.177", "192.85.160.183"));
        System.out.println(addresses);
    }
}
