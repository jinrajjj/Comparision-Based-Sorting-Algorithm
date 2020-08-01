package edu.uncc.cci.algods;

/*
Project 01
Authors: Ankit Pandita, Jinraj Jain
*/

class InsertionSort {
    void performInsertionSort(int[] intArray) {
        int size = intArray.length;
        for (int j = 1; j <= size-1; j++) {
            int key = intArray[j];
            int i = j - 1;
            while ((i >= 0) && (intArray[i] > key)) {
                intArray[i + 1] = intArray[i];
                i--;
            }
            intArray[i + 1] = key;
        }
    }
}
