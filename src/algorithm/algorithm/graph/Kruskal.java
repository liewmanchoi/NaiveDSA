package algorithm.graph;

import ds.graph.AbstractGraph;
import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedUndirectedGraph;
import ds.tree.UnionFind;

import java.util.*;

/**
 * @author wangsheng
 * @date 2018/10/24
 */
public class Kruskal {
    public static <T>
    AbstractGraph<T> generateMST(WeightedUndirectedGraph<T> graph) {
        if (graph == null || graph.isEmpty()) {
            return null;
        }

        // 创建最小生成树，包含所有图中的所有顶点
        AbstractGraph<T> mst = new WeightedUndirectedGraph<>(graph.vertexSet());

        // 使用并查集
        UnionFind<Vertex<T>> unionFind = new UnionFind<>(graph.vertexSet());
        // 堆用于存储图中的所有边
        Queue<Edge<T>> heap = new PriorityQueue<>(graph.edgeSet());

        while (mst.edgeSet().size() < 2 * (mst.vertexSet().size() - 1) && !heap.isEmpty()) {
            Edge<T> minEdge = heap.poll();
            Vertex<T> begin = minEdge.getBegin();
            Vertex<T> end = minEdge.getEnd();

            // 如果边的两个顶点不是连通的，即不属于同一个并查集，那么就不会构成回路
            if (!unionFind.isConnected(begin, end)) {
                // 则向最小生成树中加入该边
                mst.addEdge(minEdge);
                // 并且，在并查集中合并这两个顶点
                unionFind.union(begin, end);
            }
        }

        assert(mst.edgeSet().size() == 2 * (mst.vertexSet().size() - 1));
        return mst;
    }
}
