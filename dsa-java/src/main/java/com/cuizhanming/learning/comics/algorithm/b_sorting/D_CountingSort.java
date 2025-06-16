package com.cuizhanming.learning.comics.algorithm.b_sorting;

public class D_CountingSort {

    public static int[] countingSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] countArr = new int[max + 1];
        for (int k : arr) {
            countArr[k]++;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                    arr[index++] = i;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 6, 3, 9, 3, 1, 6};
        arr = countingSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
