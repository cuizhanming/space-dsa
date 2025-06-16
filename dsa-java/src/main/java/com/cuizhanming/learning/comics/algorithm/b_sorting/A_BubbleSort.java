package com.cuizhanming.learning.comics.algorithm.b_sorting;

public class A_BubbleSort {

    /**
     * 冒泡排序
     * O(n^2)
     * @param arr 待排序数组
     */
    public static void sortV1(int[] arr) {
        // 一共要经过 arr.length - 1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮后，最后的 i 个元素已经排好序了，不需要再比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序
     * O(n^2)
     * 如果进行到某一轮没有发生交换，说明数组已经有序，可以提前结束
     * @param arr 待排序数组
     */
    public static void sortV2(int[] arr) {
        // 一共要经过 arr.length - 1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            // 每一轮后，最后的 i 个元素已经排好序了，不需要再比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 如果有元素交换，说明数组无序
                    isSorted = false;
                }
            }
            // 如果某一轮没有发生交换，说明数组已经有序
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     * O(n^2)
     * 如果进行到某一轮没有发生交换，说明数组已经有序，可以提前结束
     * 记录最后一次交换的位置，减少比较次数
     * @param arr 待排序数组
     */
    public static void sortV3(int[] arr) {
        // 记录最后一次交换的位置
        int lastSwapIndex = 0;
        // 有序区边界
        int sortBorder = arr.length - 1;

        // 一共要经过 arr.length - 1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            // 每一轮只需要循环到有序区的边界
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 如果有元素交换，说明数组无序
                    isSorted = false;
                    // 更新最后一次交换的位置
                    lastSwapIndex = j;
                }
            }
            // 更新有序区边界
            sortBorder = lastSwapIndex;
            // 如果某一轮没有发生交换，说明数组已经有序
            if (isSorted) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        sortV1(arr);
//        sortV2(arr);
//        sortV3(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
