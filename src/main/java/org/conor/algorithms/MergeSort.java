package org.conor.algorithms;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    public void mergeSortRecursive(int[] arr, int left, int right) {
        System.out.printf("Calling mergeSortRecursive %s \nleftPointer:[%d] = %d \nrightPointer:[%d] = %d\n",
                Arrays.toString(arr), left, arr[left], right, arr[right]);
        if(left < right) {
            int middle = left + (right - left) / 2;
            System.out.println("calculated middlePointer: [" + middle + "] = " + arr[middle]);
            System.out.println("--Calling mergeSortRecursive on the Left Side of this call stack " + Arrays.toString(arr));
            mergeSortRecursive(arr, left, middle);
            System.out.println("--Calling mergeSortRecursive on the Right Side of this call stack " + Arrays.toString(arr));
            mergeSortRecursive(arr, middle + 1, right);
            System.out.println("------------------Before merging: " + Arrays.toString(arr)
                    + "\nleftPointer: [" + left + "] = " + arr[left]
                    + "\nmiddlePointer: [" + middle + "] = " + arr[middle]
                    + "\nrightPointer: [" + right + "] = " + arr[right]);
            merge(arr, left, middle, right);
            System.out.println("------------------After merging: " + Arrays.toString(arr));
        }
    }

    public void merge(int[] arr, int left, int middle, int right) {
        System.out.println("----> Calling merge " + Arrays.toString(arr));

        // sizes of temp arrays
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        // temp arrays
        int[] tempLeftArray = new int[leftSize];
        int[] tempRightArray = new int[rightSize];

        // Copy into temp arrays
        for(int i = 0; i < leftSize; i++) {
            tempLeftArray[i] = arr[left + i];
        }
        System.out.println("tempLeftArray " + Arrays.toString(tempLeftArray));
        for(int j = 0; j < rightSize; j++) {
            tempRightArray[j] = arr[middle + 1 + j];
        }
        System.out.println("tempRightArray " + Arrays.toString(tempRightArray));

        int i = 0, j = 0; //initial indexes of subarrays
        int k = left; //initial index of merged subarray

        while(i < leftSize && j < rightSize) {
            System.out.printf("Index of tempLeftArray i = [%d]\n", i);
            System.out.printf("Index of tempRightArray j = [%d]\n", j);
            System.out.printf("Index of mergedSubArray k = [%d]\n", k);
            System.out.println("QUESTION! Is tempLeftArray at i [" + i + "]" + " = " + tempLeftArray[i]
                    + " < tempRightArray at j [" + j + "]" + " = " + tempRightArray[j]);
            if(tempLeftArray[i] < tempRightArray[j]) {
                System.out.println("Yes it is. Array Before: " + Arrays.toString(arr));
                arr[k] = tempLeftArray[i];
                System.out.println("Array After: " + Arrays.toString(arr));
                i++;
                System.out.printf("i++ = [%d]\n", i);
            } else {
                System.out.println("No it is not. Array Before: " + Arrays.toString(arr));
                arr[k] = tempRightArray[j];
                System.out.println("Array After: " + Arrays.toString(arr));
                j++;
                System.out.printf("j++ = [%d]\n", j);            }
            k++;
            System.out.printf("k++ = [%d]\n", k);
        }

        // Copy remaining elements of tempLeftArray, if any
        while (i < leftSize) {
            System.out.println("REMAINING ELEMENTS!! - Before copy remaining elements of tempLeftArray" + Arrays.toString(arr));
            arr[k] = tempLeftArray[i];
            System.out.println("After copy remaining elements of tempLeftArray" + Arrays.toString(arr));
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightSize) {
            System.out.println("REMAINING ELEMENTS!! - Before copy remaining elements of tempRightArray" + Arrays.toString(arr));
            arr[k] = tempRightArray[j];
            System.out.println("After copy remaining elements of tempRightArray" + Arrays.toString(arr));
            j++;
            k++;
        }
    }
}
