package algorithm.search;

import ds.heap.BinaryHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    private int[] array = {1, 2, 3, 4, 4, 7, 13, 13, 13, 14, 15, 17, 17, 19};

    @Test
    public void search() {
        assertEquals(-1, BinarySearch.search(array, 0));
        assertEquals(-1, BinarySearch.search(array, 20));
        assertEquals(1, BinarySearch.search(array, 2));
        assertEquals(9, BinarySearch.search(array, 14));
    }

    @Test
    public void firstIndexOf() {
        assertEquals(-1, BinarySearch.firstIndexOf(array, 0));
        assertEquals(9, BinarySearch.firstIndexOf(array, 14));
        assertEquals(3, BinarySearch.firstIndexOf(array, 4));
        assertEquals(6, BinarySearch.firstIndexOf(array, 13));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(-1, BinarySearch.lastIndexOf(array, 0));
        assertEquals(9, BinarySearch.lastIndexOf(array, 14));
        assertEquals(4, BinarySearch.lastIndexOf(array, 4));
        assertEquals(8, BinarySearch.lastIndexOf(array, 13));
    }

    @Test
    public void upperBound() {
        assertEquals(0, BinarySearch.upperBound(array, 0));
        assertEquals(-1, BinarySearch.upperBound(array, 20));
        assertEquals(5, BinarySearch.upperBound(array, 5));
        assertEquals(3, BinarySearch.upperBound(array, 4));
    }

    @Test
    public void lowerBound() {

        assertEquals(-1, BinarySearch.lowerBound(array, 0));
        assertEquals(13, BinarySearch.lowerBound(array, 20));
        assertEquals(4, BinarySearch.lowerBound(array, 5));
        assertEquals(4, BinarySearch.lowerBound(array, 4));
    }
}