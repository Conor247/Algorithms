package org.conor.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeSort() {
        MergeSort mergeSort = new MergeSort();

        int[] arr = {80, 10, 70, 20, 60, 30, 50, 40};
        int[] expectedArray = {10, 20, 30, 40, 50, 60, 70, 80};

        long startTime = System.currentTimeMillis();
        mergeSort.sort(arr);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken: " + duration + " milliseconds");

        assertArrayEquals(expectedArray, arr);
    }
}