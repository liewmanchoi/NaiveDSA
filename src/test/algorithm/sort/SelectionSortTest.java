package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void sort() {
        Integer[] array = {8, 3, 1, 9, 4, 10, 89, 23, 2, 3};
        SelectionSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}