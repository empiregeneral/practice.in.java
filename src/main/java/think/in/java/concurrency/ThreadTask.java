package think.in.java.concurrency;

import java.util.concurrent.*;

class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "). ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }


}


class PrintNumTask implements Runnable {
    private int num;

    public PrintNumTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.print(" " + i);
            Thread.yield();
        }
    }
}

class PrintCharTask implements Runnable {
    private char ch;
    private int count;

    public PrintCharTask(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(ch);
           Thread.yield();
        }
    }
}

public class ThreadTask {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(10,
                100,
                2000L,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

        executor.execute(new PrintNumTask(100));
        executor.execute(new PrintCharTask('a', 100));
        executor.shutdown();
    }
}