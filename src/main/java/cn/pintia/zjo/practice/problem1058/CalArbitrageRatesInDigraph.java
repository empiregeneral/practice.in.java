package cn.pintia.zjo.practice.problem1058;


/**
  * @Author lei.zhu
  * @Description 在带权有向图中计算套利的Rates
  * @Date 22:30 2020/3/10
  * @Param
  * @return
 **/
public interface CalArbitrageRatesInDigraph {
    void addEdge(DirectedEdge e);

    double calArbitrageInDigraph(Integer[] pathInVertices, double money);

}
