package algorithm.sort;

/**
 * @author wangsheng
 * @date 2018/10/29
 * time complexity O(n^2)
 * space complexity O(1)
 * stable
 */
public class BubbleSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }


        for (int k = 1; k < array.length; ++k) {
            // 标记该趟遍历中 数组是否有序
            boolean isSorted = true;

            for (int i = 1; i <= array.length - k; ++i) {
                if (array[i].compareTo(array[i-1]) < 0) {
                    T temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
