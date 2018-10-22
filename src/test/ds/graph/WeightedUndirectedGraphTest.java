package ds.graph;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class WeightedUndirectedGraphTest {
    private WeightedUndirectedGraph<Integer> graph = new WeightedUndirectedGraph<>();
    @Test
    public void constructor() {
        Set<Vertex<Integer>> vertices = new HashSet<>();
        for (int i = 0; i <= 7; ++i) {
            vertices.add(new Vertex<>(i));
        }

        WeightedUndirectedGraph<Integer> graph = new WeightedUndirectedGraph<>(vertices);
        System.out.print(graph.vertexSet());

    }
    @Test
    public void removeVertex() {
        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(new Vertex<>(i));
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
        System.out.print(graph.edgeSet() + "\n");
        assertTrue(graph.removeVertex(7));
        assertFalse(graph.removeVertex(7));

        System.out.print(graph.vertexSet() + "\n");
        System.out.print(graph.edgeSet() + "\n");

    }

    @Test
    public void addEdge() {
        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(new Vertex<>(i));
        }

        graph.addEdge(0, 5, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 6, 1);
        assertFalse(graph.addEdge(5, 0, 1));
        System.out.print(graph.edgeSet());

    }

    @Test
    public void removeEdge() {
        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(new Vertex<>(i));
        }
        graph.removeEdge(5, 0);
        graph.addEdge(0, 5, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(5, 0, 1);
        assertFalse(graph.removeEdge(5, 1));
        System.out.print(graph.vertexSet() + "\n");
        System.out.print(graph.edgeSet());
    }

    @Test
    public void addEdge1() {
    }

    @Test
    public void removeEdge1() {
    }

    @Test
    public void addVertex() {
        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(new Vertex<>(i));
        }
        System.out.print(graph.vertexSet());
    }

    @Test
    public void vertexSet() {
        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(new Vertex<>(i));
        }
        System.out.print(graph.vertexSet());
    }


    @Test
    public void edgeSet() {
    }

    @Test
    public void size() {
        for (int i = 0; i <= 7; ++i) {
            graph.addVertex(new Vertex<>(i));
        }
        assertEquals(graph.size(), 8);
    }

    @Test
    public void isWeighted() {
        assertTrue(graph.isWeighted());
    }

    @Test
    public void isDirected() {
        assertFalse(graph.isDirected());
    }

    @Test
    public void depthFirstSearch() {
    }

    @Test
    public void breadthFirstSearch() {
    }
}