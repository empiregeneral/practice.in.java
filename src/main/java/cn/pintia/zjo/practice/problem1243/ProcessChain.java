package cn.pintia.zjo.practice.problem1243;

import java.util.ArrayList;
import java.util.List;

public class ProcessChain {

    private List<Readable> outputList = new ArrayList<>();
    private List<Process> chains = new ArrayList<>();

    public ProcessChain addChain(Process process) {
        chains.add(process);
        return this;
    }

    public void process(String msg) {
        for (Process chain : chains) {
            outputList.add(chain.doProcess(msg));
        }
    }

    public List<Readable> getOutputList() {
        return outputList;
    }
}
