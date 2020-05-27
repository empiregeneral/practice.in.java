package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathProcessImp implements Process, Readable {
    private int count = 1;
    private Pattern pattern = Pattern.compile("(?<=:[0-9]{1,5}|[A-Za-z])(?>=[\\/])?(([a-zA-Z0-9\\/-_%])*)?$");
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
            String result = matcher.group(1);
            cb.append("Path     = " + result);
        } else {
            cb.append("Path     = <default>");
        }
        return 10;
    }

    public static void main(String[] args) {
        Readable readable = new PathProcessImp("ftp://acm.baylor.edu:1234/pub/staff/mr-p");
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
