package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortProcessImp implements Process, Readable{
    private int count = 1;
    private Pattern pattern = Pattern.compile("://[^/?:]+:([0-9]{1,5})?");
    private String msg;

    public PortProcessImp(String msg) {
        this.msg = msg;
    }

    public PortProcessImp() {

    }


    @Override
    public Readable doProcess(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        Matcher matcher = pattern.matcher(msg);
        if (matcher.find()) {
            String result = matcher.group(1);
            cb.append("Port     = " + result);
        } else {
            cb.append("Port     = <default>");
        }
        return 10;
    }
}
