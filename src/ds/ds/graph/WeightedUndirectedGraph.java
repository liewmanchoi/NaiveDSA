package ds.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangsheng
 * @date 2018/10/22
 */
public class WeightedUndirectedGraph<T> extends AbstractGraph<T> {
    public WeightedUndirectedGraph(Set<Vertex<T>> vertices) {
        super(vertices, false, true);
    }

    public WeightedUndirectedGraph() {
        super(false, true);
    }

    @Override
    public boolean removeVertex(Vertex<T> vertex) {
        if (!map.containsKey(vertex)) {
            return false;
        }

        Set<Edge<T>> edgeSet = new HashSet<>(map.get(vertex));

        for (Edge<T> edge : edgeSet) {
            removeEdge(edge);
        }
        map.remove(vertex);
        return true;
    }

    public boolean removeVertex(T vertexUniqueId) {
        Vertex<T> vertex = new Vertex<>(vertexUniqueId);
        return removeVertex(vertex);
    }

    public boolean addEdge(T beginUniqueId, T endUniqueId, double weight) {
        Edge<T> edge = new Edge<>(beginUniqueId, endUniqueId, weight);
        // 注意HashSet的优良特性
        return addEdge(edge);
    }

    public boolean removeEdge(T beginUniqueId, T endUniqueId) {
        Edge<T> edge = new Edge<>(beginUniqueId, endUniqueId);
        return removeEdge(edge);
    }

    @Override
    public boolean addEdge(Edge<T> edge) {
        if (edge == null) {
            return false;
        }
        Vertex<T> begin = edge.getBegin();
        Vertex<T> end = edge.getEnd();

        if (!map.containsKey(begin) || !map.containsKey(end)) {
            return false;
        }

        return map.get(begin).add(edge) && map.get(end).add(edge.reversed());
    }

    @Override
    public boolean removeEdge(Edge<T> edge) {
        if (edge == null) {
            return false;
        }

        Vertex<T> begin = edge.getBegin();
        Vertex<T> end = edge.getEnd();

        if (!map.containsKey(begin) || !map.containsKey(end)) {
            return false;
        }

        return map.get(begin).remove(edge) && map.get(end).remove(edge.reversed());
    }


}
