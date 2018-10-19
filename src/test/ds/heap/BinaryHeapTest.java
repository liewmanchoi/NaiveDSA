package ds.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryHeapTest {
    @Test
    public void constructor() {
        Integer[] elems = {8, 18, 7, 4, 5, 6, 14, 31};
        List<Integer> li = new LinkedList<>(Arrays.asList(elems));
        BinaryHeap<Integer> heap = new BinaryHeap<>(li);
        assertEquals(heap.size(), 8);
        System.out.print(heap);
    }

    @Test
    public void size() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertEquals(heap.size(), 0);
        heap.offer(1);
        heap.offer(2);
        heap.offer(8);
        heap.offer(4);
        assertEquals(heap.size(), 4);
        heap.poll();
        heap.poll();
        assertEquals(heap.size(), 2);
    }

    @Test
    public void isEmpty() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.isEmpty());
        heap.offer(1);
        heap.offer(2);
        assertFalse(heap.isEmpty());
        heap.poll();
        heap.poll();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void insert() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.insert(5));
        assertTrue(heap.insert(3));
        assertTrue(heap.insert(8));
        assertTrue(heap.insert(12));
        assertFalse(heap.insert(null));
        assertTrue(heap.insert(7));
        assertTrue(heap.insert(9));
        assertTrue(heap.insert(15));
        heap.poll();
        heap.insert(1);

        System.out.print(heap.toString());

    }

    @Test
    public void contains() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.insert(5));
        assertTrue(heap.insert(3));
        assertTrue(heap.insert(8));
        assertTrue(heap.insert(12));
        assertTrue(heap.insert(7));
        assertTrue(heap.insert(9));
        assertTrue(heap.insert(15));
        assertFalse(heap.contains(null));
        assertTrue(heap.contains(9));
        assertFalse(heap.contains(18));
    }

    @Test
    public void remove() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.insert(5));
        assertTrue(heap.insert(3));
        assertTrue(heap.insert(8));
        assertTrue(heap.insert(12));
        assertTrue(heap.insert(7));
        assertFalse(heap.remove(null));
        assertTrue(heap.insert(9));
        assertTrue(heap.insert(15));
        assertFalse(heap.remove(1));
        assertTrue(heap.remove(7));
        assertTrue(heap.remove(8));
        assertTrue(heap.remove(3));
        System.out.println(heap);

    }

    @Test
    public void peek() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.insert(5));
        assertTrue(heap.insert(3));
        assertTrue(heap.insert(8));
        assertFalse(heap.insert(null));
        assertTrue(heap.insert(12));
        assertTrue(heap.insert(7));
        assertTrue(heap.insert(9));
        assertTrue(heap.insert(15));
        assertEquals(heap.peek(), Integer.valueOf(3));
        heap.poll();
        assertEquals(heap.peek(), Integer.valueOf(5));
        heap.insert(1);
        heap.insert(3);
        assertEquals(heap.peek(), Integer.valueOf(1));
        heap.clear();
        assertNull(heap.peek());
    }

    @Test
    public void offer() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.offer(5));
        assertTrue(heap.offer(3));
        assertTrue(heap.offer(8));
        assertTrue(heap.offer(12));
        assertTrue(heap.offer(7));
        assertTrue(heap.insert(9));
        assertTrue(heap.insert(15));
        assertEquals(heap.peek(), Integer.valueOf(3));
    }

    @Test
    public void poll() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.insert(5));
        assertTrue(heap.insert(3));
        assertTrue(heap.insert(8));
        assertFalse(heap.insert(null));
        assertTrue(heap.insert(12));
        assertTrue(heap.insert(7));
        assertTrue(heap.insert(9));
        assertEquals(heap.poll(), Integer.valueOf(3));
        heap.insert(1);
        heap.insert(3);
        assertEquals(heap.poll(), Integer.valueOf(1));
        heap.clear();
        assertNull(heap.poll());
    }

    @Test
    public void clear() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.clear();
    }

//    @Test
//    public void toString() {
//    }
}