package edu.uncc.cci.algods;

/*
Project 01
Authors: Ankit Pandita, Jinraj Jain
*/

class HeapSort {
    private void heapify(int[] intArray, int size, int i) {
        // Initialize largest as root
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int temp;
        // If left child is larger than root
        if (left < size && intArray[left] > intArray[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < size && intArray[right] > intArray[largest]) {
            largest = right;
        }
        // If largest is not root
        if (largest != i) {
            temp = intArray[i];
            intArray[i] = intArray[largest];
            intArray[largest] = temp;
            // Recursively heapify the affected sub-tree
            heapify(intArray, size, largest);
        }
    }

    void performHeapSort(int[] intArray) {
        int size = intArray.length;
        int i;
        int temp;
        // Build heap (rearrange array)
        for (i = size / 2 - 1; i >= 0; i--) {
            heapify(intArray, size, i);
        }
        // One by one extract an element from heap
        for (i = size - 1; i >= 0; i--) {
            // Move current root to end
            temp = intArray[0];
            intArray[0] = intArray[i];
            intArray[i] = temp;
            // call max heapify on the reduced heap
            heapify(intArray, i, 0);
        }
    }
}