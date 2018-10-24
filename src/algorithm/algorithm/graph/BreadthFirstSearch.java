package algorithm.graph;


import ds.graph.AbstractGraph;
import ds.graph.Vertex;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author wangsheng
 * @date 2018/10/22
 */
public class BreadthFirstSearch<T> {
    private AbstractGraph<T> graph;

    public BreadthFirstSearch(AbstractGraph<T> graph) {
        this.graph = graph;
    }

    public void search(Consumer<Vertex<T>> action) {
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.vertexSet()) {
            search(vertex, action, visited);
        }
    }

    private void search(Vertex<T> root, Consumer<Vertex<T>> action, Set<Vertex<T>> visited) {
        if (root == null || visited.contains(root)) {
            return;
        }
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Vertex<T> cur = queue.poll();
            if (!visited.contains(cur)) {
                action.accept(cur);
                visited.add(cur);

                for (Vertex<T> neighbor : graph.getNeighbors(cur)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
}
