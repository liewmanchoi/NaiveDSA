package algorithm.graph;

import ds.graph.WeightedUndirectedGraph;
import org.junit.Test;

public class BreadthFirstSearchTest {

    @Test
    public void search() {
        WeightedUndirectedGraph<Integer> graph = new WeightedUndirectedGraph<>();

        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 5, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 7, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(6, 4, 1);
        graph.addEdge(7, 4, 1);
        graph.addEdge(7, 1, 1);
        graph.addEdge(5, 4, 1);
        graph.addEdge(5, 3, 1);
        graph.addEdge(3, 4, 1);

        BreadthFirstSearch<Integer> graphs = new BreadthFirstSearch<>(graph);
        graphs.search(System.out::print);
    }
}