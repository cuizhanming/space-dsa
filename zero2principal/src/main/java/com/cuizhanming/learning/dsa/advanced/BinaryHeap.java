package com.cuizhanming.learning.dsa.advanced;

import java.util.Arrays;

/**
 * Binary heap is array special kind of heap, it is array complete binary tree.
 * It satisfies the heap property: the value of the parent node is always greater than/equal to (or less than/equal to) the value of any child node.
 */
public class BinaryHeap {

    public static int[] buildMinHeap(int[] array) {
        // start from the last node's parent.
        // last leaf node index: index = array.length - 1
        // its parent index: (index - 1) / 2 ==> (array.length -2) / 2
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downwardAdjustmentMin(array, i, array.length);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downwardAdjustmentMax(array, i, array.length);
        }
    }

    /**
     * Insert a new element into min heap
     */
    public static int[] insertForMinHeap(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        buildMinHeap(array);
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        upwardAdjustmentMin(newArray);
        return newArray;
    }

    /**
     * Insert a new element into max heap
     */
    public static int[] insertForMaxHeap(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        buildMaxHeap(array);
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        upwardAdjustmentMax(newArray);
        return newArray;
    }

    /**
     * Delete the root node of the min heap
     */
    public static void deleteRootForMinHeap(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("The heap is empty.");
        }
        array[0] = array[array.length - 1];
        downwardAdjustmentMin(array, 0, array.length);
        array[array.length - 1] = 0;
    }

    /**
     * Delete the root node of the max heap
     */
    public static void deleteRootForMaxHeap(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("The heap is empty.");
        }
        array[0] = array[array.length - 1];
        downwardAdjustmentMax(array, 0, array.length);
        array[array.length - 1] = 0;
    }

    /**
     * Upward adjustment to lift the last node, if it's smaller than its parent node
     */
    public static void upwardAdjustmentMin(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && array[parentIndex] > temp) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * Upward adjustment to lift the last node, if it's larger than its parent node
     */
    public static void upwardAdjustmentMax(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // Keep the value of the leaf node, so at the end to assign the value to the correct position.
        int temp = array[childIndex];
        // Loop the child position to the root node
        while (childIndex > 0 && array[parentIndex] < temp) {
            // Assign parent value to the child position
            array[childIndex] = array[parentIndex];
            // Change the child position to current parent position
            childIndex = parentIndex;
            // Change the parent position to upper level parent.
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * Downward adjustment to sink the root node, if it's smaller than its child node
     */
    public static void downwardAdjustmentMin(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // if right child is smaller than left child, use right child
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // if parent node is smaller than child node, break
            if (temp <= array[childIndex]) {
                break;
            }
            // swap parent node and child node
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        // set the parent node to the last child node
        array[parentIndex] = temp;
    }

    /**
     * Downward adjustment to sink the root node, if it's larger than its child node
     */
    public static void downwardAdjustmentMax(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = parentIndex * 2 + 1;
        while (childIndex < length) {
            // if right child is bigger than left child, use right child
            if (childIndex+1 < length && array[childIndex+1] > array[childIndex]) {
                childIndex++;
            }
            // if parent node is bigger than child node, break
            if (temp >= array[childIndex]) {
                break;
            }
            // swap parent node and child node
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        // set the parent node to the last child node
        array[parentIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {105, 85, 2, 6, 95, 7, 8, 9, 10, 100};
        buildMinHeap(array);
        System.out.println(Arrays.toString(array)); // [2, 6, 7, 9, 95, 105, 8, 85, 10, 100]
        deleteRootForMinHeap(array);
        System.out.println(Arrays.toString(array)); // [6, 9, 7, 85, 95, 105, 8, 100, 10, 0]

        buildMaxHeap(array);
        System.out.println(Arrays.toString(array));

    }
}
