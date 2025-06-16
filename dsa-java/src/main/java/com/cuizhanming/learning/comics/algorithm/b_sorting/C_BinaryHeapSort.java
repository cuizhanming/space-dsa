package com.cuizhanming.learning.comics.algorithm.b_sorting;

import com.cuizhanming.learning.comics.datastructure.advanced.BinaryHeap;

import java.util.Arrays;

class C_BinaryHeapSort {

    public static void heapSort(int[] array) {
        BinaryHeap.buildMaxHeap(array);
        System.out.println(Arrays.toString(array));

        // remove the root node (max) to the end of the current size heap.
        for (int i = array.length - 1; i > 0; i--){
            var temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // Here, the `i` is the new size of the heap, which suggests the tree is smaller and smaller.
            BinaryHeap.downwardAdjustmentMax(array, 0, i);
        }
    }

    public static void main(String[] args) {
        var array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}