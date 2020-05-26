package cn.pintia.zjo.practice.problem1243;

import java.util.regex.Pattern;

public interface Process {
    Readable doProcess(String msg, Pattern pattern);
}
