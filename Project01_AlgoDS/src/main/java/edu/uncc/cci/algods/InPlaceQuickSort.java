package edu.uncc.cci.algods;

/*
Project 01
Authors: Ankit Pandita, Jinraj Jain
*/

class InPlaceQuickSort {
    private int[] input;

    void performInPlaceQuickSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        int length = numbers.length;
        quickSort(0, length - 1);
    }

    /* This method implements in-place quick sort algorithm recursively. */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        // pivot is middle index
        int pivot = input[low + (high - low) / 2];
        // Divide into two arrays
        while (i <= j) {
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }
        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}