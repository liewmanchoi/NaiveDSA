package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void sort() {
        Integer[] array = {};
        BubbleSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}