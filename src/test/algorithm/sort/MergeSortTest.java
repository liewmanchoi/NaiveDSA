package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {
        Integer[] array = new Integer[]{7, 12, 68, 15, 34, 98, 4, 9, 16, 94, 1, 30, 4, 8};
        MergeSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}