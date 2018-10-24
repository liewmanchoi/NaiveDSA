package graph;

import ds.graph.AbstractGraph;
import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedUndirectedGraph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wangsheng
 * @date 2018/10/24
 * This is Prim's greedy Minimum Spanning Tree algorithm which can be used in connected weighted graphs.
 * Algorithms starts building MST by randomly choosing one vertex. Then, we add least weighted edge from already
 * selected vertices and add its adjacent vertex to tree if it is not already in the tree.
 * Running time is O(V^2). It can be done O(E+ V logV) by using Fibonacci heap.
 */
public class Prim<T> {

    public static <T>
    AbstractGraph<T> generateMST(WeightedUndirectedGraph<T> graph) {
        if (graph == null || graph.isEmpty()) {
            return null;
        }

        AbstractGraph<T> mst = new WeightedUndirectedGraph<>();
        // 从vertexSet顶点集合中随机选取一个顶点
        Vertex<T> root = graph.vertexSet().iterator().next();
        // 将该顶点作为生成树的第一个节点
        mst.addVertex(root);

        // 二叉堆用于存储生成树的邻居节点的边权重
        Queue<Edge<T>> heap = new PriorityQueue<>(graph.getEdges(root));

        while (!heap.isEmpty()) {
            Edge<T> minEdge = heap.poll();
            Vertex<T> endVertex = minEdge.getEnd();

            if (mst.vertexSet().contains(endVertex)) {
                continue;
            }

            mst.addVertex(endVertex);
            mst.addEdge(minEdge);
            heap.addAll(graph.getEdges(endVertex));
        }

        return mst;
    }
}
