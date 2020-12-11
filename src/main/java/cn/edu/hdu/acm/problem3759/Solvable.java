package cn.edu.hdu.acm.problem3759;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solvable implements Readable {
    final private int capacity = 7462;
    private int handScore;
    private int count = 1;
    private int v = 0;

    List<Hand.HandScore> handScores = new ArrayList<>(capacity);

    public Solvable(int handScore) {
        this.handScore = handScore;
    }

    /**
     * @param handScore 生成的牌面分数
     * @param pos  C1 C2 C3 C4 C5
     * @param rankOfHigh 牌面的最高值 ACE -> indexOf("23456789TJQKA") = 12 依次类推
     * @param hc 牌面的花色 0 -> C, 1 -> D, 2 -> S, 3 -> H
     * @param canflush 是否是同花
     */
    void generate(int handScore, int pos, int rankOfHigh, int hc, boolean canflush) {
        if (hc > 1) {
            canflush = false;
        }
        if (pos == -1) {
            generate(handScore, -2, rankOfHigh, hc, canflush);
            if (canflush) {
                generate(Hand.setFlush(handScore), -2, rankOfHigh, hc, canflush);
            }
        } else if (pos == -2) {
            handScores.add(new Hand.HandScore(handScore));
        } else {
            for (int rank = rankOfHigh; rank >= 0; rank--){
                if (rank < rankOfHigh || hc < Hand.S.length()) {
                    generate(Hand.setCard(handScore, pos, rank), pos - 1, rank, rank < rankOfHigh ? 1 : (hc + 1), canflush);
                }
            }
        }
    }


    public int solve() {
        generate(0, Hand.C1, Hand.ACE, 0, true);
        Collections.sort(handScores);
        boolean found = false;
        for (Hand.HandScore handScore : handScores) {
            this.v++;
            if (handScore.hand == this.handScore) {
                found = true;
                break;
            }
        }
        assert found;
        return v;
    }


    @Override
    public int read(CharBuffer cb) throws IOException {

        if (--count < 0) {
            return -1;
        }
        solve();

        cb.append(""+v);

        return 10;
    }

    public static int solution(int handScore) {
        int result = new Solvable(handScore).solve();
        return result;
    }
}
