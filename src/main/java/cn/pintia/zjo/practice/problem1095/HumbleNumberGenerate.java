package cn.pintia.zjo.practice.problem1095;

public class HumbleNumberGenerate implements Generate {
    private int p2;
    private int p3;
    private int p5;
    private int p7;
    private final int step2=2;
    private final int step3=3;
    private final int step5=5;
    private final int step7=7;
    private int[] humbleNumbers;
    private int capacity;
    private int index = 0;

    public HumbleNumberGenerate() {
        this(5842);
    }

    public HumbleNumberGenerate(int capacity) {
        this.capacity = capacity;
        humbleNumbers = new int[this.capacity+1];
        humbleNumbers[0] = 1;
        p2 = 0;
        p3 = 0;
        p5 = 0;
        p7 = 0;
    }

    public void dp() {
        humbleNumbers[++index] = Math.min(Math.min(humbleNumbers[p2] * step2, humbleNumbers[p3] * step3), Math.min(humbleNumbers[p5] * step5, humbleNumbers[p7] * step7));
        if (humbleNumbers[index] == humbleNumbers[p2] * step2) {
            p2++;
        }
        if (humbleNumbers[index] == humbleNumbers[p3] * step3) {
            p3++;
        }
        if (humbleNumbers[index] == humbleNumbers[p5] * step5) {
            p5++;
        }
        if (humbleNumbers[index] == humbleNumbers[p7] * step7) {
            p7++;
        }
    }

    @Override
    public int next() {
        dp();
        return humbleNumbers[index];
    }

    @Override
    public int[] createTable() {
        while(hasNext()) {
            next();
        }
        return humbleNumbers;
    }

    public boolean hasNext() {
        return (index < capacity) ;
    }

}
