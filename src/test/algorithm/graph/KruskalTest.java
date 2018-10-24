package algorithm.graph;

import ds.graph.AbstractGraph;
import ds.graph.WeightedUndirectedGraph;
import org.junit.Test;

public class KruskalTest {

    @Test
    public void generateMST() {
        String vertices = "ZBWXDLHYFC";
        WeightedUndirectedGraph<Character> graph  = new WeightedUndirectedGraph<>();
        for (int i = 0; i < vertices.length(); ++i) {
            graph.addVertex(vertices.charAt(i));
        }

        graph.addEdge('Z', 'W', 1);
        graph.addEdge('Z', 'B', 1);
        graph.addEdge('B', 'W', 1);
        graph.addEdge('B', 'D', 1);
        graph.addEdge('D', 'L', 1);
        graph.addEdge('B', 'L', 1);
        graph.addEdge('W', 'X', 1);
        graph.addEdge('W', 'H', 1);
        graph.addEdge('L', 'H', 1);
        graph.addEdge('H', 'X', 1);
        graph.addEdge('L', 'F', 1);
        graph.addEdge('X', 'Y', 1);
        graph.addEdge('H', 'F', 1);
        graph.addEdge('H', 'Y', 1);
        graph.addEdge('F', 'C', 1);
        graph.addEdge('H', 'C', 1);
        graph.addEdge('Y', 'C', 1);

        AbstractGraph<Character> result = Kruskal.generateMST(graph);
        System.out.print(result);
    }
}