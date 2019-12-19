package cn.pintia.zjo.practice.problem2947;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
  * @Author lei.zhu
  * @Description zjo 2947的主算法，求解两个缩略字符串是否相同。
  * @Date 20:39 2019/12/14
  * @Param
  * @return
 **/
public class CheckAbbreviation implements Readable, Comparator<CharSequence> {
    private String firstWords;
    private String secondWords;
    private CharSequence abbrevFirst;
    private CharSequence abbrevSecond;
    private int count = 1;

    public CheckAbbreviation(String firstWords, String secondWords) {
        this.firstWords = firstWords;
        this.secondWords = secondWords;
        this.abbrevFirst = abbreviateWords(this.firstWords);
        this.abbrevSecond = abbreviateWords(this.secondWords);
    }

    private CharSequence abbreviateWords(String words) {
        StringBuilder sb = new StringBuilder("");
        StringTokenizer token = new StringTokenizer(words);
        while (token.hasMoreTokens()) {
            sb.append(token.nextToken().charAt(0));
        }
        return sb.toString();
    }

    private String checkTwoAbbrevWords() {
        return (compare(abbrevFirst, abbrevSecond) == 0) ? "SAME" : "DIFFERENT";
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        cb.append(checkTwoAbbrevWords());
        cb.append("");

        return 10;
    }

    /**
     * @Author lei.zhu
     * @Description 注意equals的使用，需要考虑0 1 -1三种情况
     * @Date 14:00 2019/12/16
     * @Param [o1, o2]
     * @return int
     **/
    @Override
    public int compare(CharSequence o1, CharSequence o2) {
        if ((o1.length() == o2.length()) && (o1.equals(o2))) {
            return 0;
        } else if (o1.length() > o2.length()) {
            return 1;
        } else {
            return -1;
        }
    }
}
