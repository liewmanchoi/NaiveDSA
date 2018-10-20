package ds.heap;
import ds.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * @author wangsheng
 * @date 2018/10/17
 * 默认为小顶堆
 */
public class BinaryHeap<E extends Comparable<? super E>> implements Tree<E>  {
    private final static int DEFAULT_INIT_SIZE = 11;

    private int size;
    private final Comparator<? super E> comparator;
    private ArrayList<E> heap;

    public BinaryHeap() {
        this(DEFAULT_INIT_SIZE, Comparator.naturalOrder());
    }

    public BinaryHeap(int initSize) {
        this(initSize, Comparator.naturalOrder());
    }

    public BinaryHeap(int initSize, Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>(initSize);
        this.size = 0;

    }

    public BinaryHeap(E[] elems) {
        this(Arrays.asList(elems));
    }


    public BinaryHeap(Collection<? extends E> collection) {
        this.comparator = Comparator.naturalOrder();
        this.heap = new ArrayList<>(collection);
        this.size = heap.size();

        // 调整结构，保持堆的有序性
        heapify();

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean insert(E element) {
        if (element == null) {
            return false;
        }

        heap.add(element);
        this.size++;
        // 调整破坏后的堆结构
        // 注意heap的起始编号为0
        shiftUp(size() - 1, element);
        return true;
    }

    @Override
    public boolean contains(E element) {
        return !isEmpty() && heap.contains(element);
    }

    @Override
    public boolean remove(E element) {
        int idx = heap.indexOf(element);
        if (idx == -1) {
            return false;
        }
        removeAt(idx);
        return true;
    }

    private E removeAt(int idx) {
        if (isEmpty() || idx >= size() || idx < 0) {
            return null;
        }
        this.size--;
        // 将要删除的元素
        E toRemoved = heap.get(idx);
        // 删除并获取堆的最后一个元素值
        E moved = heap.remove(size());

        if (idx != size()) {
            // 如果删除的不是最后一个堆元素，
            // 则调整破坏后的堆结构
            shiftDown(idx, moved);
        }
        return toRemoved;
    }

    public E peek() {
        if (isEmpty()) {
            return  null;
        }

        return heap.get(0);
    }

    public boolean offer(E element) {
        return insert(element);
    }

    public E poll() {
        return removeAt(0);
    }

    public void clear() {
        heap.clear();
        this.size = 0;
    }

    /**
     * 调整底层数组heap，使之保持有序性
     */
    private void heapify() {
        if (isEmpty()) {
            return;
        }

        int lastNonLeaf = size() / 2 - 1;
        for (int idx = lastNonLeaf; idx >= 0; --idx) {
            shiftDown(idx, heap.get(idx));
        }
    }

    /**
     * 上滤算法
     * @param idx: 上滤的起始位置
     * @param element: 上滤处拟插入的值
     */
    private void shiftUp(int idx, E element) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            E e = heap.get(parent);
            if (comparator.compare(element, e) >= 0) {
                // 如果element大于等于parent的值，则跳出循环
                break;
            }
            // 否则，将idx的值设置为parent的值
            heap.set(idx, e);
            // idx更新为parent
            idx = parent;
        }
        // 最终停止的位置的值设置为element
        heap.set(idx, element);
    }

    /**
     * 下滤算法
     * @param idx: 下滤的起始节点
     * @param element: 下滤处的值
     */
    private void shiftDown(int idx, E element) {
        int lastNonLeaf = size() / 2  - 1;
        while (idx <= lastNonLeaf) {
            int leftChild = 2 * idx + 1;
            int rightChild = leftChild + 1;
            int smallestChild = leftChild;
            // 最后一个非叶节点lastNonLeaf只能保证一定有左子节点，因此要增加对是否有右子节点的判断
            if (rightChild < size() && comparator.compare(heap.get(leftChild), heap.get(rightChild)) > 0) {
                smallestChild = rightChild;
            }
            E e = heap.get(smallestChild);
            if (comparator.compare(element, e) <= 0) {
                break;
            }
            heap.set(idx, e);
            idx = smallestChild;
        }
        heap.set(idx, element);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
