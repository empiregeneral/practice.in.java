package think.in.java.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexUtil {
    // 全字符串匹配
    public static boolean isMatch(String regex, String input){
        if (null == input) {
            return false;
        }
        return input.matches(regex);
    }

    // 包含子字符串
    public static boolean contains(String regex, String input){
        Pattern r = Pattern.compile(regex);
        return r.matcher(input).find();
    }

    // 实现indexOf
    public static int indexOf(String regex, String input){
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(input);
        int index = -1;
        if(m.find()) {
            index = m.start();
        }

        return index;
    }

    // 实现lastIndexOf
    public static int lastIndexOf(String regex, String input){
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(input);
        int index = -1;
        while(m.find()) {
            index = m.start();
        }

        return index;
    }

    // 替换全部匹配字符串
    public static String replaceAll(String regex, String input, String replacement){
        if (null == regex || regex.isEmpty()) {
            return input;
        }
        return input.replaceAll(regex, replacement);
    }

    // 替换第N个匹配字符串
    public static String replaceSome(String regex, String input, String replacement, int n){
        if (null == regex || regex.isEmpty()) {
            return input;
        }
        if (0 == n) {
            return input.replaceFirst(regex, replacement);
        }

        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(input);
        int i = 0;
        StringBuffer buffer = new StringBuffer();
        while (i <= n && m.find()){
            if (i == n){
                m.appendReplacement(buffer, replacement);
                m.appendTail(buffer);
            }
            ++i;
        }
        if (0 == buffer.length()) {
            buffer.append(input);
        }

        return buffer.toString();
    }

    // 萃取字符串
    public static String extract(String regex, String input){
        String ret = "";
        Pattern r = Pattern.compile(regex);
        Matcher m = r.matcher(input);
        if (m.find()) {
            ret = m.group();
        }

        return ret;
    }

    // 拆分字符串
    public static String[] split(String regex, String input, int limit){
        if (null == input || input.isEmpty()
                || null == regex || regex.isEmpty()) {
            return new String[]{input};
        }
        return input.split(regex, limit);
    }
}
