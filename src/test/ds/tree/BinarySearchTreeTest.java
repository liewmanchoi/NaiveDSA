package ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    @Test
    public void insert() {
        assertTrue(tree.insert(8));
        assertTrue(tree.insert(7));
        assertTrue(tree.insert(35));
        assertFalse(tree.insert(7));
    }

    @Test
    public void contains() {
        tree.insert(9);
        tree.insert(12);
        tree.insert(8);
        assertTrue(tree.contains(8));
        assertFalse(tree.contains(1));
    }

    @Test
    public void remove() {
        tree.insert(9);
        tree.insert(12);
        tree.insert(8);
        tree.preOrderTraversal(System.out::print);
        assertTrue(tree.remove(9));
        //assertFalse(tree.remove(12));
        assertFalse(tree.remove(3));
        tree.preOrderTraversal(System.out::print);
    }

    @Test
    public void findMin() {
        tree.insert(9);
        tree.insert(12);
        tree.insert(8);
        tree.insert(1);
        tree.insert(42);
        tree.insert(9);
        tree.remove(9);
        assertEquals(Integer.valueOf(1), tree.findMin());

    }

    @Test
    public void findMax() {
        tree.insert(9);
        tree.insert(12);
        tree.insert(8);
        tree.insert(1);
        tree.insert(42);
        tree.insert(9);
        assertEquals(Integer.valueOf(42), tree.findMax());
    }

    @Test
    public void isEmpty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        assertTrue(bst.isEmpty());
        bst.insert(5);
        assertFalse(bst.isEmpty());

    }

    @Test
    public void preOrderTraversal() {
        tree.insert(9);
        tree.insert(12);
        tree.insert(8);
        tree.insert(42);
        tree.insert(15);
        tree.insert(1);

        tree.preOrderTraversal(System.out::println);
    }

    @Test
    public void inOrderTraversal() {
        tree.insert(9);
        tree.insert(12);
        tree.insert(8);
        tree.insert(42);
        tree.insert(15);
        tree.insert(1);
        tree.inOrderTraversal(System.out::println);
    }

    @Test
    public void postOrderTraversal() {
        tree.insert(10);
        tree.insert(12);
        tree.insert(8);
        tree.insert(42);
        tree.insert(15);
        tree.insert(1);
        tree.postOrderTraversal(System.out::println);
    }

    @Test
    public void levelOrderTraversal() {
        tree.insert(10);
        tree.insert(12);
        tree.insert(8);
        tree.insert(42);
        tree.insert(15);
        tree.insert(1);
        tree.levelOrderTraversal(System.out::println);
    }

    @Test
    public void getHeight() {
        tree.insert(10);
        tree.insert(12);
        tree.insert(8);
        tree.insert(42);
        tree.insert(15);
        tree.insert(1);
        assertEquals(Integer.valueOf(4), Integer.valueOf(tree.getHeight()));
    }
}