package cn.pintia.zjo.practice.problem2645;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class IpAddressToBinaryStr {
    private String address;
    private String binaryAddress;
    private List<String> addressList;

    public IpAddressToBinaryStr(String address) {
        this.address = address;
        this.binaryAddress = transform(this.address);
    }

    public IpAddressToBinaryStr(List<String> addressList) {
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
        return new IpAddressToBinaryStr(originAddress).binaryAddress;
    }

    public static List<String> valueOf(List<String> addresses) {
        return new IpAddressToBinaryStr(addresses).addressList;
    }
}
