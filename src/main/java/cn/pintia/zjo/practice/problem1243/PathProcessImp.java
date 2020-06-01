package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathProcessImp implements Process, Readable {
    private int count = 1;
    private Pattern pattern = Pattern.compile("(?:([A-Za-z]+):)?(\\/{2})([-.\\-A-Za-z]+)(?::([0-9]{1,5}))?(?:\\/([^\\s]*))?$");
    private String msg;

    public PathProcessImp(String msg) {
        this.msg = msg;
    }

    public PathProcessImp() {

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
            String result = matcher.group(5);
            if (Objects.isNull(result)) {
                cb.append("Path     = <default>");
            } else {
                cb.append("Path     = " + result);
            }
        } else {
            cb.append("Path     = <default>");
        }
        return 10;
    }
}
