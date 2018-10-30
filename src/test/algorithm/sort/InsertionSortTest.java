package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void sort() {
        Integer[] array = new Integer[]{};
        InsertionSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}