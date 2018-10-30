package algorithm.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangsheng
 * @date 2018/10/29
 * time complexity O(n log(n)) - O(n^2)
 * space complexity O(log(n)) - O(n)
 * unstable
 */
public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

//        sortRecursive(array, 0, array.length - 1);
        sortIterative(array, 0, array.length - 1);
    }

    private static <T extends Comparable<? super T>> void sortRecursive(T[] array, int from, int to) {
        if (from >= to) {
            return;
        }

        int pivotIdx = partition(array, from, to);
        sortRecursive(array, from, pivotIdx-1);
        sortRecursive(array, pivotIdx+1, to);
    }

    private static <T extends Comparable<? super T>> void sortIterative(T[] array, int from, int to) {
        if (from >= to) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(to);
        stack.push(from);

        while (!stack.isEmpty()) {
            int left = stack.poll();
            int right = stack.poll();
            if (left >= right) {
                continue;
            }

            int pivotIdx = partition(array, left, right);
            stack.push(pivotIdx-1);
            stack.push(left);
            stack.push(right);
            stack.push(pivotIdx+1);
        }
    }

    /**
     *
     * @param array 待分割数组
     * @param left 左端起点
     * @param right 右端终点
     * @param <T> 元素类型
     * @return pivot索引值
     *
     * left part           right part
     * +--------------------------------------+
     * | < pivot |              ?             |
     * +--------------------------------------+
     *           |^   ^
     *            |   |
     *            p   q
     * invariants:
     * all in [left, p) < pivot
     * all in [p, q) >= pivot
     */
    private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right) {
        int pivotIdx = left + (right - left) / 2;
        T pivot = array[pivotIdx];
        // 将array[pivot]移动到array[right]处，则只需要调整[left, right-1]区间的元素
        swap(array, pivotIdx, right);
        // 划分区间[left, p)和[p, right)，
        // 指针p左端的元素[0...p-1]全部小于pivot，指针q在区间[p, right)寻找小于pivot的元素
        // 如果有，则将p和q指向的值交换，指针p和q分别前移
        int p = left;
        for (int q = p; q < right; ++q) {
            // 如果在区间[p, ...)内有小于pivot的元素，则交换p和q指向的值，区间[left, p)长度增1
            if (array[q].compareTo(pivot) < 0) {
                swap(array, p, q);
                ++p;
            }
        }

        // 将小于pivot区间的下一个元素array[p]与array[right] == pivot值交换，则p成为新的pivotIdx
        swap(array, p, right);
        return p;
    }


    private static <T> void swap(T[] array, int i, int j) {
        if (i == j) {
            return;
        }

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
