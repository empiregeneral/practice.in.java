package cn.pintia.zjo.practice.test.problem1111;

import cn.pintia.zjo.practice.problem1111.ShowHandInDeck;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

public class FutureTaskTest {
    public static void main(String[] args) {
        CountLines countLines = new CountLines(System.in);
        int nThreads = countLines.getLineNo();
        List<String> content = countLines.getLineContent();
        System.out.println(nThreads);
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        try {
            List<Future<Map<Integer, String>>> futureList = new ArrayList<>(nThreads);
            for (int i = 0; i < nThreads; i++) {
                Callable<Map<Integer, String>> task = new JudgeTask(Integer.valueOf(i+1), content.get(i));
                futureList.add(executor.submit(task));
            }

            while(futureList.size() > 0) {
                Iterator<Future<Map<Integer, String>>> iterator = futureList.iterator();
                while(iterator.hasNext()) {
                    Future<Map<Integer, String>> futureTask = iterator.next();
                    if (futureTask.isDone() && !futureTask.isCancelled()) {
                        System.out.println(futureTask.get());
                        iterator.remove();
                    } else {
                        Thread.sleep(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            executor.shutdown();
        }
    }
}

class JudgeTask implements Callable<Map<Integer, String>>, Comparator<JudgeTask> {
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
    public Map<Integer, String> call() throws Exception {
        Map<Integer, String> map = new HashMap<>();
        String result = "";
        Integer no = 0;
        Readable readable = new ShowHandInDeck(this.hands);
        Scanner output = new Scanner(readable);
        while (output.hasNextLine()) {
            result = output.nextLine();
            no = this.no;
            map.put(no, result);
        }
        return map;
    }

    @Override
    public int compare(JudgeTask o1, JudgeTask o2) {
        return (o1.no - o2.no);
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