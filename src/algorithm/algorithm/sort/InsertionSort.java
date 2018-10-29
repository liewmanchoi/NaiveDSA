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
            for (int j = i - 1; j >= 0 && array[j].compareTo(array[j+1]) > 0; --j) {
                T temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
}
