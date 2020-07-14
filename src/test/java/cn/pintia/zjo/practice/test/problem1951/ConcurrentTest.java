package cn.pintia.zjo.practice.test.problem1951;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class ConcurrentTest {
    public static void main(String[] args) {
        Class[] cls = {Problem1951Test.class};
        Result rt = JUnitCore.runClasses(cls);
        System.out.println("TestCases " + rt.getRunCount() + "  time consuming " + rt.getRunTime() + "ms.");
        rt.getFailures().forEach(System.out::println);
    }
}
