package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathProcessImp implements Process, Readable {
    private int count = 1;
    private Pattern pattern = Pattern.compile("://[^/?:]+:([0-9]{1,5})?(?:\\/([^?#/]+))?(?:\\?([^/]*))?(?:/(.*))?$");
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
            String result = matcher.group(2);
            cb.append("Path     = " + result);
        } else {
            cb.append("Path     = <default>");
        }
        return 10;
    }

    public static void main(String[] args) {
        Readable readable = new PathProcessImp("http://www.informatik.uni-ulm.de/acm");
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
