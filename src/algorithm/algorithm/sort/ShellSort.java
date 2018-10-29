package algorithm.sort;

/**
 * @author wangsheng
 * @date 2018/10/29
 */
public class ShellSort {
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        int[] sedgewick = {929, 505, 209, 109, 41, 5, 1, 0};
        int intervalIdx = 0;
        while (sedgewick[intervalIdx] > array.length) {
            ++intervalIdx;
        }

        for(int interval = sedgewick[intervalIdx]; interval > 0; interval = sedgewick[++intervalIdx]) {
            for (int i = interval; i < array.length; i++) {
                T insertionValue = array[i];
                int j = i;
                while (j >= interval && array[j - interval].compareTo(insertionValue) > 0) {
                    array[j] = array[j - interval];
                    j -= interval;
                }
                array[j] = insertionValue;
            }
        }
    }
}
