package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void sort() {
        Integer[] array = new Integer[]{12, 68, 15, 34, 98, 4, 9, 16, 94, 30, 4, 8};
        QuickSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}