package edu.uncc.cci.algods;

/*
Project 01
Authors: Ankit Pandita, Jinraj Jain
*/

class MedianOfThreeQuickSort {

    void performSort(int[] intArray) {
        recQuickSort(intArray, 0, intArray.length - 1);
    }

    private void recQuickSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(intArray, left, right);
        else {
            double median = medianOfThree(intArray, left, right);
            int partition = partitionIt(intArray, left, right, median);
            recQuickSort(intArray, left, partition - 1);
            recQuickSort(intArray, partition + 1, right);
        }
    }

    private int medianOfThree(int[] intArray, int left, int right) {
        int center = (left + right) / 2;

        if (intArray[left] > intArray[center])
            swap(intArray, left, center);

        if (intArray[left] > intArray[right])
            swap(intArray, left, right);

        if (intArray[center] > intArray[right])
            swap(intArray, center, right);

        swap(intArray, center, right - 1);
        return intArray[right - 1];
    }

    private void swap(int[] intArray, int dex1, int dex2) {
        int temp = intArray[dex1];
        intArray[dex1] = intArray[dex2];
        intArray[dex2] = temp;
    }

    private int partitionIt(int[] intArray, int left, int right, double pivot) {
        int leftPointer = left;
        int rightPointer = right - 1;

        while (true) {
            while (intArray[++leftPointer] < pivot)
                ;
            while (intArray[--rightPointer] > pivot)
                ;
            if (leftPointer >= rightPointer)
                break;
            else
                swap(intArray, leftPointer, rightPointer);
        }
        swap(intArray, leftPointer, right - 1);
        return leftPointer;
    }

    private void manualSort(int[] intArray, int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (intArray[left] > intArray[right])
                swap(intArray, left, right);
        } else {
            if (intArray[left] > intArray[right - 1])
                swap(intArray, left, right - 1);
            if (intArray[left] > intArray[right])
                swap(intArray, left, right);
            if (intArray[right - 1] > intArray[right])
                swap(intArray, right - 1, right);
        }
    }
}