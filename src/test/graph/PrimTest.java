package graph;

import ds.graph.AbstractGraph;
import ds.graph.WeightedUndirectedGraph;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimTest {

    @Test
    public void generateMST() {
        String vertices = "ZBWXDLHYFC";
        WeightedUndirectedGraph<Character> graph  = new WeightedUndirectedGraph<>();
        for (int i = 0; i < vertices.length(); ++i) {
            graph.addVertex(vertices.charAt(i));
        }

        graph.addEdge('Z', 'W', 5);
        graph.addEdge('Z', 'B', 8);
        graph.addEdge('B', 'W', 5);
        graph.addEdge('B', 'D', 5);
        graph.addEdge('D', 'L', 4);
        graph.addEdge('B', 'L', 4);
        graph.addEdge('W', 'X', 8);
        graph.addEdge('W', 'H', 4);
        graph.addEdge('L', 'H', 4);
        graph.addEdge('H', 'X', 7);
        graph.addEdge('L', 'F', 2);
        graph.addEdge('X', 'Y', 5);
        graph.addEdge('H', 'F', 3);
        graph.addEdge('H', 'Y', 5);
        graph.addEdge('F', 'C', 7);
        graph.addEdge('H', 'C', 6);
        graph.addEdge('Y', 'C', 6);

        AbstractGraph<Character> result = Prim.generateMST(graph);
        System.out.print(result.vertexSet());
        System.out.print(result.edgeSet());
    }
}