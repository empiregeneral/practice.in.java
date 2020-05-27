package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProtocolProcessImp implements Process, Readable{
    private int count = 1;
    private Pattern pattern = Pattern.compile("^(?:([A-Za-z]+):)");
    private String msg;

    public ProtocolProcessImp(String msg) {
        this.msg = msg;
    }

    public ProtocolProcessImp() {

    }


    @Override
    public Readable doProcess(String msg) {
        this.msg = msg;
        this.pattern = pattern;
        return this;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        Matcher matcher = pattern.matcher(msg);
        while(matcher.find()) {
            String result = matcher.group(0);
            cb.append("Protocol = " + result.substring(0, result.length() - 1));
        }
        return 10;
    }
}
