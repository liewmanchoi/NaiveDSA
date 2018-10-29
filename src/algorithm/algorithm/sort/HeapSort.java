package algorithm.sort;

/**
 * @author wangsheng
 * @date 2018/10/29
 * time complexity O(n log(n))
 * space complexity O(1)
 * unstable
 */
public class HeapSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        // 在array上建立大顶堆
        heapify(array);
        // 依次将堆的最大元素移到尾端，堆的长度不断减少
        for (int heapSize = array.length; heapSize > 1; ) {
            int lastIdx = heapSize - 1;
            T toBeMoved = array[lastIdx];

            // 删除堆顶元素，堆大小减一
            array[lastIdx] = array[0];
            --heapSize;

            shiftDown(array, 0, heapSize, toBeMoved);
        }
    }

    /**
     * 大顶堆的下滤算法
     * @param array 堆所在的数组
     * @param idx 下滤起始索引
     * @param heapSize 堆的大小
     * @param element 需要比较下滤的值
     * @param <T> 值的类型
     */
    private static <T extends Comparable<? super T>> void shiftDown(T[] array, int idx, int heapSize, T element) {
        // 最后一个非叶子节点的索引
        int lastNonLeftIdx = heapSize / 2 - 1;

        while (idx <= lastNonLeftIdx) {
            // 先将最大子节点索引maxChildIdx设置为左子节点的索引
            int maxChildIdx = 2 * idx + 1;
            // 如果右子节点存在，且array[maxChildIdx] < array[maxChildIdx+1]
            if (maxChildIdx + 1 < heapSize && array[maxChildIdx].compareTo(array[maxChildIdx + 1]) < 0) {
                maxChildIdx = maxChildIdx + 1;
            }

            // 如果element >= array[maxChildIdx]，说明element已经抵达合适位置，堆有序
            if (element.compareTo(array[maxChildIdx]) >= 0) {
                break;
            }
            // 否则，需要将子节点上移
            array[idx] = array[maxChildIdx];
            idx = maxChildIdx;
        }
        // 不要忘记将element放置在合适的位置
        array[idx] = element;
    }

    /**
     * 在array数组上建立大顶堆
     * @param <T> 元素类型
     */
    private static <T extends Comparable<? super T>> void heapify(T[] array) {
        int lastNonLeafIdx = array.length / 2 - 1;

        for (int idx = lastNonLeafIdx; idx >=0; --idx) {
            shiftDown(array, idx, array.length, array[idx]);
        }
    }
}
