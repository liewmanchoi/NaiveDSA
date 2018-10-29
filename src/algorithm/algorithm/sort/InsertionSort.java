package algorithm.sort;

/**
 * @author wangsheng
 * @date 2018/10/29
 * time complexity O(n^2)
 * space complexity O(1)
 * stable
 */
public class InsertionSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        for (int i = 1; i < array.length; ++i) {
            T insertionValue = array[i];
            int j = i;
            while (j >= 1 && array[j-1].compareTo(insertionValue) > 0) {
                array[j] = array[j-1];
                --j;
            }
            array[j] = insertionValue;
        }
    }
}
