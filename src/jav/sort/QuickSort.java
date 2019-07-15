package jav.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 3, 12, 5, 2, 8, 9, 6, 11, 10, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int pivot = arr[left];

        while (i < j) {
            //从右向左找小于pivot的
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            //找到小于pivot的值，移动
            if (i < j) {
                arr[i] = arr[j];
            }
            //从左向右找大于pivot的值
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = pivot;
        //左右分治
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
