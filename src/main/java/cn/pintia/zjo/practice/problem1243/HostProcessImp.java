package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostProcessImp implements Process, Readable{
    private int count = 1;
    private Pattern pattern = Pattern.compile("://([^/?:]+)(:[0-9]{1,5})?(/?|(/[^/]+))");
    private String msg;

    public HostProcessImp(String msg) {
        this.msg = msg;
    }

    public HostProcessImp() {

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
        while(matcher.find()) {
            String result = matcher.group(1);
            cb.append("Host     = " + result);
        }
        cb.append("\n");
        return 10;
    }

    public static void main(String[] args) {
        Readable readable = new HostProcessImp("gopher://veryold.edu");
        Scanner scanner = new Scanner(readable);
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
