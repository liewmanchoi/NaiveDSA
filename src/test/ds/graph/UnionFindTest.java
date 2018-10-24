package ds.graph;

import ds.tree.UnionFind;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void add() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }

        UnionFind<Integer> unionFind = new UnionFind<>(list);
        assertFalse(unionFind.add(1));
        assertTrue(unionFind.add(5));
    }

    @Test
    public void find() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }

        UnionFind<Integer> unionFind = new UnionFind<>(list);
        assertEquals(unionFind.find(1), Integer.valueOf(1));
        assertEquals(unionFind.find(4), Integer.valueOf(4));
        unionFind.union(1, 4);
        assertEquals(unionFind.find(1), Integer.valueOf(1));
        assertEquals(unionFind.find(4), Integer.valueOf(1));
    }

    @Test
    public void union() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }

        UnionFind<Integer> unionFind = new UnionFind<>(list);
        unionFind.union(0, 1);
        unionFind.union(2, 4);
        unionFind.union(0, 3);
        unionFind.union(0, 4);
        assertEquals(unionFind.find(4), Integer.valueOf(0));
        assertEquals(unionFind.find(3), Integer.valueOf(0));
        System.out.print(unionFind);
    }

    @Test
    public void isConnected() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            list.add(i);
        }

        UnionFind<Integer> unionFind = new UnionFind<>(list);
        unionFind.union(0, 1);
        unionFind.union(2, 4);
        unionFind.union(0, 3);
        System.out.print(unionFind);
        assertTrue(unionFind.isConnected(1, 3));
        assertFalse(unionFind.isConnected(1, 2));
    }
}