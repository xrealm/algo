package jav.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 3, 12, 5, 2, 8, 9, 6, 11, 10, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        //构建大顶堆
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length - 1; i > 0; i--) {
            //交换堆顶元素和最后一个元素
            int t = arr[0];
            arr[0] = arr[i];
            arr[i] = t;
            //下沉调整
            heapAdjust(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        //从最后一个非叶子节点，依次下沉调整
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
    }

    /**
     * 下城调节堆顶
     * @param arr 堆数组
     * @param parentIndex 要调整的父节点
     * @param length 堆长度
     */
    private static void heapAdjust(int[] arr, int parentIndex, int length) {
        //temp保存父节点值，用于最后赋值
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子大于左孩子
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            //父节点大于任何一个子节点的值，跳出这次循环
            if (temp >= arr[childIndex]) {
                break;
            }
            //覆盖原父节点的值
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = temp;
    }
}
