package algorithm.sort;

/**
 * @author wangsheng
 * @date 2018/10/28
 * time complexity O(n^2)
 * space complexity O(1)
 * stable
 */
public class SelectionSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        for (int cur = 0; cur < array.length; ++cur) {
            // find the index of min element in array[cur+1, array.length)
            int minIndex = cur;
            for (int fromIndex = minIndex + 1; fromIndex < array.length; ++fromIndex) {
                if (array[fromIndex].compareTo(array[minIndex]) < 0) {
                    minIndex = fromIndex;
                }
            }

            // if current element is not the min element in array[cur, array.length)
            if (cur != minIndex) {
                T temp = array[cur];
                array[cur] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
