package edu.uncc.cci.algods;

/*
Project 01
Authors: Ankit Pandita, Jinraj Jain
*/

class MergeSort {
    private void merge(int[] intArray, int startIndex, int middleIndex, int lastIndex) {
        int l = middleIndex - startIndex + 1;
        int r = lastIndex - middleIndex;
        int i, j;
        int[] LeftArray = new int[l];
        int[] RightArray = new int[r];
        for (i = 0; i < l; i++) {
            LeftArray[i] = intArray[startIndex + i];
        }
        for (j = 0; j < r; j++) {
            RightArray[j] = intArray[middleIndex + 1 + j];
        }
        i = 0;
        j = 0;
        int k = startIndex;
        while (i < l && j < r) {
            if (LeftArray[i] <= RightArray[j]) {
                intArray[k] = LeftArray[i];
                i++;
            } else {
                intArray[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            intArray[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < r) {
            intArray[k] = RightArray[j];
            j++;
            k++;
        }
    }

    private void performMergeSort(int[] intArray, int startIndex, int lastIndex) {
        if (startIndex < lastIndex) {
            int middleIndex = (startIndex + lastIndex) / 2;
            performMergeSort(intArray, startIndex, middleIndex);
            performMergeSort(intArray, middleIndex + 1, lastIndex);
            merge(intArray, startIndex, middleIndex, lastIndex);
        }
    }

    void sort(int[] intArray) {
        performMergeSort(intArray, 0, intArray.length - 1);
    }
}