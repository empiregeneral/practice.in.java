package cn.pintia.zjo.practice.problem2724;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String command = scanner.nextLine();

        }
    }
}

class WindowsProcessMsg implements Comparable<WindowsProcessMsg> {
    private String command;
    private String param;
    private Integer priority;

    public WindowsProcessMsg(String command, String param, Integer priority) {
        this.command = command;
        this.param = param;
        this.priority = priority;
    }

    @Override
    public int compareTo(WindowsProcessMsg other) {
        return this.priority - other.priority;
    }
}

interface Command {
    void execute();
}

class Receiver {
    public void action(String input) {


    }

}

class GetCommand implements Command {


    @Override
    public void execute() {

    }
}

class PutCommand implements Command {


    @Override
    public void execute() {

    }
}

class Solution implements Readable {
    private int count = 1;

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        return 10;
    }
}