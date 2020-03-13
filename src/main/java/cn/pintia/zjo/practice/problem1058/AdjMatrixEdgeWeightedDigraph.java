package cn.pintia.zjo.practice.problem1058;


import java.util.*;

public class AdjMatrixEdgeWeightedDigraph implements CalArbitrageRatesInDigraph{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;


    private DirectedEdge[][] adj;

    /**
     * Initializes an empty edge-weighted digraph with {@code V} vertices and 0 edges.
     *
     * @param V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public AdjMatrixEdgeWeightedDigraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("number of vertices must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        this.adj = new DirectedEdge[V][V];
    }

    /**
     * Initializes a random edge-weighted digraph with {@code V} vertices and <em>E</em> edges.
     *
     * @param V the number of vertices
     * @param E the number of edges
     * @throws IllegalArgumentException if {@code V < 0}
     * @throws IllegalArgumentException if {@code E < 0}
     */
    public AdjMatrixEdgeWeightedDigraph(int V, int E) {
        this(V);
        if (E < 0) {
            throw new IllegalArgumentException("number of edges must be nonnegative");
        }
        if (E > V * V) {
            throw new IllegalArgumentException("too many edges");
        }

        // can be inefficient
        while (this.E != E) {
            int v = new Random().nextInt(5);
            int w = new Random().nextInt(5);
            double weight = Math.round(100 * (new Random().nextDouble())) / 100.0;
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    /**
     * Returns the number of vertices in the edge-weighted digraph.
     *
     * @return the number of vertices in the edge-weighted digraph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the edge-weighted digraph.
     *
     * @return the number of edges in the edge-weighted digraph
     */
    public int E() {
        return E;
    }


    /**
     * @return DirectedEdge[][]
     * @Author lei.zhu
     * @Date 21:22 2020/3/8
     * @Param []
     **/
    private DirectedEdge[][] getAdj() {
        return adj;
    }

    /**
     * @return double weight
     * @Author lei.zhu
     * @Description
     * @Date 23:37 2020/3/9
     * @Param [from, to]
     **/
    public double getWeight(int from, int to) {
        return adj[from][to].weight();
    }

    @Override
    public double calArbitrageInDigraph(Integer[] pathInVertices, double money) {
        int Size = pathInVertices.length;
        double[] rates = new double[Size-1];
        for (int i = 1; i < Size; i++) {
            rates[i-1] = getWeight(pathInVertices[i-1], pathInVertices[i]);
        }

        double expectMoney = money;

        for (double rate : rates) {
            expectMoney = Math.round(expectMoney * rate * 100) / 100.00;
        }

        return expectMoney;
    }



    /**
     * Adds the directed edge {@code e} to the edge-weighted digraph (if there
     * is not already an edge with the same endpoints).
     *
     * @param e the edge
     */
    @Override
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        if (adj[v][w] == null) {
            E++;
            adj[v][w] = e;
        }
    }

    /**
     * Returns the directed edges incident from vertex {@code v}.
     *
     * @param v the vertex
     * @return the directed edges incident from vertex {@code v} as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<DirectedEdge> adj(int v) {
        validateVertex(v);
        return new AdjMatrixEdgeWeightedDigraph.AdjIterator(v);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<DirectedEdge>, Iterable<DirectedEdge> {
        private int v;
        private int w = 0;

        public AdjIterator(int v) {
            this.v = v;
        }

        @Override
        public Iterator<DirectedEdge> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w] != null) {
                    return true;
                }
                w++;
            }
            return false;
        }

        @Override
        public DirectedEdge next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return adj[v][w++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns a string representation of the edge-weighted digraph. This method takes
     * time proportional to <em>V</em><sup>2</sup>.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     * followed by the <em>V</em> adjacency lists of edges
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj(v)) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }


}
