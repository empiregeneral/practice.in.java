package think.in.java.concurrence;

public class LiftOff implements Runnable{
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
        this(10);
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "). ";
    }


    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
            System.out.println("Wait for LiftOff.");
        }
    }
}
