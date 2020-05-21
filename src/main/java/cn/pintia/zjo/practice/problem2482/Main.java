package cn.pintia.zjo.practice.problem2482;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String bits = "00000000000000000000000000000000";
        Pattern pattern =Pattern.compile("(?<=[01])(?=([01]{3}+(?![01])))");
        pattern.matcher(bits);
    }
}
