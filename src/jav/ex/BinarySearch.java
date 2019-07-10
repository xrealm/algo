package jav.ex;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 7, 9, 13, 22, 33, 44, 55};
        int index = binarySearch(arr, 13);
        if (index > 0) {
            System.out.println("find: " + index);
        } else {
            System.out.println("insert: " + ~index);
        }
    }

    private static int binarySearch(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (arr[mid] < k) {
                //从右边继续找
                lo = mid + 1;
            } else if (arr[mid] > k) {
                //从左边继续找
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return ~lo;
    }
}
