package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ShellSortTest {

    @Test
    public void sort() {
        Integer[] array = new Integer[]{905, 78, 4, 13, 95, 9, 12, 8, 43, 54, 6, 1, 3, 1,  24,  15};
        ShellSort.sort(array);
        System.out.print(Arrays.toString(array));
    }
}