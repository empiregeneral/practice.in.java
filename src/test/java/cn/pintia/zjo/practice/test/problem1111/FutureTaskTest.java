package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.ShowHandInDeck;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) {
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        int lines = 0;
        List<String> contents = new LinkedList<>();
        Scanner input = new Scanner(new BufferedInputStream(System.in));
        while(input.hasNextLine()) {
            String content = input.nextLine();
            contents.add(content);
            ++lines;
        }
        try {
            List<Future<TaskResult>> futureList = new ArrayList<>(lines);
            for (int i = 0; i < lines; i++) {
                Callable<TaskResult> task = new JudgeTask(Integer.valueOf(i+1), contents.get(i));
                futureList.add(executor.submit(task));
            }

            List<TaskResult> resultList = new ArrayList<TaskResult>();
            while(futureList.size() > 0) {
                Iterator<Future<TaskResult>> iterator = futureList.iterator();
                while(iterator.hasNext()) {
                    Future<TaskResult> future = iterator.next();
                    if (future.isDone() && !future.isCancelled()) {
                        resultList.add(future.get());
                        iterator.remove();
                    } else {
                        Thread.sleep(1);
                    }
                }
            }

            Collections.sort(resultList);

            Iterator<TaskResult> iterator = resultList.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next().getResult());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class JudgeTask implements Callable<TaskResult> {
    private String hands;
    private Integer no;

    public JudgeTask(String hands) {
        this.hands = hands;
    }

    public JudgeTask(Integer no, String hands) {
        this.hands = hands;
        this.no = no;
    }

    @Override
    public TaskResult call() throws Exception {
        String result = "";
        Integer lineNo = 0;
        Readable readable = new ShowHandInDeck(this.hands);
        Scanner output = new Scanner(readable);
        while (output.hasNextLine()) {
            result = output.nextLine();
            lineNo = this.no;
            return new TaskResult(lineNo, result);
        }
        return null;
    }
}

class CountLines {
    private Integer lineNo = 0;
    private List<String> lineContent = new LinkedList<>();

    public CountLines(InputStream in) {
        Scanner scanner = new Scanner(in);
        while(scanner.hasNextLine()) {
            ++lineNo;
            lineContent.add(scanner.nextLine());
        }
    }

    public Integer getLineNo() {
        return lineNo;
    }


    public List<String> getLineContent() {
        return lineContent;
    }
}

class TaskResult extends ThreadLocal<TaskResult> implements Comparable<TaskResult> {

    private Integer lineNo;
    private String result;

    public TaskResult(Integer lineNo, String result) {
        this.lineNo = lineNo;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public int compareTo(TaskResult o) {
        return lineNo - o.lineNo;
    }
}