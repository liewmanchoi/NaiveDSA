package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void sort() {
        Integer[] array = new Integer[]{};
        HeapSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}