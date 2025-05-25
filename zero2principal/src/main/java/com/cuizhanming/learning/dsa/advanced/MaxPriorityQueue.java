package com.cuizhanming.learning.dsa.advanced;

import static com.cuizhanming.learning.dsa.advanced.BinaryHeap.upwardAdjustmentMax;

public class MaxPriorityQueue {
    private int[] array;
    private int size;

    public MaxPriorityQueue(int capacity) {
        array = new int[capacity + 1];
        size = capacity;
    }

    public void insert(int data) {
        if (size == array.length - 1) {
            throw new RuntimeException("The priority queue is full.");
        }
        array[++size] = data;
        upwardAdjustmentMax(array);
    }
}
