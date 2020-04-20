package cn.pintia.zjo.practice.problem1058;

public class DirectedEdge  {
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        if (v < 0) {
            throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        } else if (w < 0) {
            throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        } else if (Double.isNaN(weight)) {
            throw new IllegalArgumentException("Weight is NaN");
        } else {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }

    public int from() {
        return this.v;
    }

    public int to() {
        return this.w;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.v + "->" + this.w + " " + String.format("%5.7f", this.weight);
    }
}
