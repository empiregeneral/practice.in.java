package think.in.java.concurrence;



import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(1024, 1024, 2000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            pool.execute(new LiftOff());
        }

        pool.shutdown();

    }
}
