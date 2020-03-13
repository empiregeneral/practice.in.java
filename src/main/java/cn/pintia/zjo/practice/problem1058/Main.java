package cn.pintia.zjo.practice.problem1058;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedInputStream(System.in));

        final int V = 5;

        int blocks = input.nextInt();
        input.nextLine();
        for (int block = 0; block < blocks; block++) {
            CalArbitrageRatesInDigraph G = new AdjMatrixEdgeWeightedDigraph(V);
            for (int from = 0; from < V; from++) {
                for (int to = 0; to < V; to++) {
                    double rate = input.nextDouble();
                    DirectedEdge e = new DirectedEdge(from, to, rate);
                    G.addEdge(e);
                }
            }

            input.nextLine();

            while(input.hasNextLine()) {
                String[] inputArr = input.nextLine().split(" ");
                int N = Integer.valueOf(inputArr[0]);

                if (N == 0) {
                    break;
                }

                double money = Double.valueOf(inputArr[inputArr.length - 1]);

                List<Integer> vertices = new ArrayList<Integer>(N+2);
                vertices.add(0);
                for (int i = 1; i <= N; i++) {
                    vertices.add(Integer.valueOf(inputArr[i]) - 1);
                }
                vertices.add(0);

                Integer[] verticesArr = vertices.toArray(new Integer[vertices.size()]);

                double ans = G.calArbitrageInDigraph(verticesArr, money);
                System.out.println(new BigDecimal(ans).setScale(2, RoundingMode.HALF_UP).toString());
            }

            if (block != blocks-1) {
                System.out.println();
            }
        }
    }
}
