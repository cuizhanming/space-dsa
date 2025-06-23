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

    public static int[] optimizedCountingSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int range = max - min + 1;
        int[] countArr = new int[range];
        System.out.println("memory array size: "+countArr.length);
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                arr[index++] = i + min;
            }
        }
        return arr;
    }

    public static int[] optimizedCountingSortWithPosition(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        int range = max - min + 1;
        int[] counterArr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            counterArr[arr[i] - min]++;
        }

        // calculate the position of each counter
        for (int i = 1; i < counterArr.length; i++) {
            counterArr[i] += counterArr[i-1];
        }

        // calculate the sortedArr based on counterArr
        int[] sortedArr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[counterArr[arr[i]-min] - 1] = arr[i];
            counterArr[arr[i]-min]--;
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{5, 8, 6, 3, 9, 3, 1, 6};
        //arr = countingSort(arr);
        int[] arr = new int[]{95, 98, 96, 93, 99, 93, 91, 96, 88, 76, 84, 79};
        //arr = optimizedCountingSort(arr); // 76 79 84 88 91 93 93 95 96 96 98 99
        arr = optimizedCountingSortWithPosition(arr); // 76 79 84 88 91 93 93 95 96 96 98 99 
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
