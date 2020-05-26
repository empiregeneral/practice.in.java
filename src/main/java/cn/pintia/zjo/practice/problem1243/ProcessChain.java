package cn.pintia.zjo.practice.problem1243;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProcessChain implements Readable{
    private int count = 1;

    private List<Process> chains = new ArrayList<>();

    public ProcessChain addChain(Process process) {
        chains.add(process);
        return this;
    }

    public Readable process(String msg, Pattern pattern) {
        for (Process chain : chains) {
            chain.doProcess(msg, pattern);
        }
        return this;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (--count < 0) {
            return -1;
        }

        return 10;
    }
}
