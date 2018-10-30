package algorithm.sort;

import java.util.*;

/**
 * @author wangsheng
 * @date 2018/10/30
 * time complexity O(n log(n))
 * space complexity O(n)
 * stable
 */
public class MergeSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        List<T> helper = new ArrayList<>(Arrays.asList(array));
//        sortRecursive(array, helper, 0, array.length - 1);
        sortIterative(array, helper, 0, array.length - 1);
    }

    private static <T extends Comparable<? super T>> void sortIterative(T[] array, List<T> helper, int from, int to) {
        if (from >= to) {
            return;
        }

        // 由于递归版sortRecursive不是尾递归，因此很难采用栈模拟的方法
        // 不妨回归到MergeSort的本源:
        // len为参与递归的左侧数组的长度，右侧数组长度可能<= len
        // len每次增加为上一次的2倍
        // 左侧数组 [left, left + len - 1]
        // 右侧数组 [left + len, left + 2 * len - 1]或者[left + len, array.length - 1]
        for (int len = 1; len <= array.length; len *= 2) {
            int left, right;
            // 参与合并的右侧数组的个数至少为1，即left + len < array.length
            for (left = 0; left + len < array.length; left = right + 1) {
                // 确保最右侧索引right不超出界限
                right = left + 2 * len - 1;
                if (right > array.length - 1) {
                    right = array.length - 1;
                }

                // 如果只有一个数，则没有merge的必要
                if (right == left) {
                    continue;
                }

                int mid = left + len - 1;
                merge(array, helper, left, mid, right);
            }
        }

    }

    private static <T extends Comparable<? super T>> void sortRecursive(T[] array, List<T> helper,
                                                                        int from, int to) {
        if (from >= to) {
            return;
        }
        int mid = from + (to - from) / 2;
        sortRecursive(array, helper, from, mid);
        sortRecursive(array, helper, mid+1, to);
        merge(array, helper, from, mid, to);

    }

    private static <T extends Comparable<? super T>> void merge(T[] array, List<T> helper,
                                                                int from, int mid, int to) {
        // 合并有序数组array[from, mid]和array[mid+1, to]至helper[from, to]
        // 然后将help[from, to]复制回array[from, to]

        int leftIdx = from;
        int rightIdx = mid + 1;
        int helperIdx = leftIdx;
        while (leftIdx <= mid && rightIdx <= to) {
            if (array[leftIdx].compareTo(array[rightIdx]) < 0) {
                helper.set(helperIdx, array[leftIdx]);
                ++leftIdx;
            } else {
                helper.set(helperIdx, array[rightIdx]);
                ++rightIdx;
            }

            ++helperIdx;
        }

        while (leftIdx <= mid) {
            helper.set(helperIdx, array[leftIdx]);
            ++leftIdx;
            ++helperIdx;
        }

        while (rightIdx <= to) {
            helper.set(helperIdx, array[rightIdx]);
            ++rightIdx;
            ++helperIdx;
        }

        // 将helper复制回原array
        for (int idx = from; idx <= to; ++idx) {
            array[idx] = helper.get(idx);
        }
    }
}
