package algorithm.search;

/**
 * @author wangsheng
 * @date 2018/11/6
 */
public class BinarySearch {
    public static int search(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < key) {
                lo = mid + 1;
            } else if (array[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int firstIndexOf(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < key) {
                lo = mid + 1;
            } else if (array[mid] > key) {
                hi = mid - 1;
            } else {
                if (mid == 0 || array[mid-1] != key)  {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int lastIndexOf(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] < key) {
                lo = mid + 1;
            } else if (array[mid] > key) {
                hi = mid - 1;
            } else {
                if (mid == array.length - 1 || array[mid+1] != key) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }

    public static int upperBound(int[] array, int key) {
        // 第一个>=key的元素
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] >= key) {
                if (mid == 0 || array[mid-1] < key) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static int lowerBound(int[] array, int key) {
        // 最后一个<=key的元素
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] <= key) {
                if (mid == array.length - 1 || array[mid+1] > key) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
