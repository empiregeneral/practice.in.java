package cn.pintia.zjo.practice.problem1092;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class BellmanFordSPTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        int cases = 1;

        while (true) {
            int V = scanner.nextInt();

            if (V == 0) {
                break;
            }

            String[] nations = new String[V];
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
            for (int i = 0; i < V; i++) {
                nations[i] = scanner.next();
            }

            int W = scanner.nextInt();

            for (int w = 0; w < W; w++) {
                String from = scanner.next();
                int fromIndex = findIndexInArrays(nations, from);
                double weight = Double.valueOf(scanner.next());
                String to = scanner.next();
                int toIndex = findIndexInArrays(nations, to);
                DirectedEdge e = new DirectedEdge(fromIndex, toIndex, -Math.log(weight));
                G.addEdge(e);
            }

            BellmanFordSP spt = new BellmanFordSP(G, 0);

            if (spt.hasNegativeCycle()) {
                System.out.println("Case " + cases + ":" + " Yes");
            } else {
                System.out.println("Case " + cases + ":" + " No");
            }

            cases = cases+1;
        }


    }

    /**
      * @Author lei.zhu
      * @Description 通过key线性查找nations表中对应的index
      * @Date 21:33 2020/3/15
      * @Param [sequences, seq]
      * @return int
     **/
    private static int findIndexInArrays(CharSequence[] sequences, CharSequence seq) {
        int index = -1;

        for (int i = 0; i < sequences.length; i++) {
            if (seq.equals(sequences[i])) {
                index = i;
            }
        }

        return index;
    }
}
