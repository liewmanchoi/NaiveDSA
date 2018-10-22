package ds.graph;

import java.util.*;

/**
 * 图的抽象类
 * @author wangsheng
 * @date 2018/10/22
 */
public abstract class AbstractGraph<T> implements Graph<T> {
    Map<Vertex<T>, Set<Edge<T>>> map;
    private final boolean directed;
    private final boolean weighted;
//    Set<Edge<T>> edges;

    AbstractGraph(boolean directed, boolean weighted) {
        this.map = new HashMap<>();
        this.directed = directed;
        this.weighted = weighted;
    }

    AbstractGraph(Set<Vertex<T>> vertices, boolean directed, boolean weighted) {
        this(directed, weighted);
        for (Vertex<T> vertex : vertices) {
            map.put(vertex, new HashSet<>());
        }
    }

    @Override
    public boolean addVertex(Vertex<T> vertex) {
        if (map.containsKey(vertex)) {
            return false;
        }
        map.put(vertex, new HashSet<>());
        return true;
    }

    public boolean addVertex(T vertexUniqueId) {
        return addVertex(new Vertex<>(vertexUniqueId));
    }

    @Override
    public Set<Vertex<T>> vertexSet() {
        return map.keySet();
    }

    @Override
    public Set<Edge<T>> edgeSet() {
        Collection<Set<Edge<T>>> edgeSetCollection = map.values();
        Set<Edge<T>> edges = new HashSet<>();

        for (Set<Edge<T>> edgeSet : edgeSetCollection) {
            edges.addAll(edgeSet);
        }
        return edges;
    }

    @Override
    public int size() {
        return map.size();
    }

    public boolean isWeighted() {
        return weighted;
    }

    public boolean isDirected() {
        return directed;
    }

    public Set<Vertex<T>> getNeighbors(Vertex<T> vertex) {
        if (!map.containsKey(vertex)) {
            return null;
        }

        Set<Vertex<T>> neighbors = new HashSet<>();
        for (Edge<T> edge : map.get(vertex)) {
            Vertex<T> neighbor = edge.getEnd();
            neighbors.add(neighbor);
        }
        return neighbors;
    }
}
