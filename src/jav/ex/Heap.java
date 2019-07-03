package jav.ex;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6, 11, 10, 4};
        //构建小顶堆
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void buildHeap(int[] arr) {
        //从最后一个非叶子节点开始
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
    }

    private static void adjust(int[] arr, int parentIndex, int length) {
        //左子节点
        int childIndex = 2 * parentIndex + 1;
        //保存父节点的值，用来最后赋值
        int temp = arr[parentIndex];
        while (childIndex < length) {
            //找到最小的子节点
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            //父节点小于任何一个子节点
            if (temp <= arr[childIndex]) {
                break;
            }
            //覆盖父节点
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = temp;
    }

}
