package edu.uncc.cci.algods;

import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/*
Project 01
Authors: Ankit Pandita, Jinraj Jain
*/

public class Main {
    public static void main(String[] args) {
        int[] arraySizes = {1000, 2000, 4000, 5000, 10000, 40000, 50000};
        double[] doubleIS = new double[arraySizes.length];
        double[] doubleMS = new double[arraySizes.length];
        double[] doubleHS = new double[arraySizes.length];
        double[] doubleIP = new double[arraySizes.length];
        double[] doubleM3 = new double[arraySizes.length];
        int count = 0;
        for (int i : arraySizes) {
            int[] arrNum1 = getArray(i);
            int[] arrNum2 = getArray(i);
            int[] arrNum3 = getArray(i);
            //    sortArrayAscending(arrNum1, arrNum2, arrNum3);
            //    sortArrayDescending(arrNum1, arrNum2, arrNum3);
            doubleIS[count] = getExecutionTimeIS(arrNum1, arrNum2, arrNum3);
            doubleMS[count] = getExecutionTimeMS(arrNum1, arrNum2, arrNum3);
            doubleHS[count] = getExecutionTimeHS(arrNum1, arrNum2, arrNum3);
            doubleIP[count] = getExecutionTimeIP(arrNum1, arrNum2, arrNum3);
            doubleM3[count] = getExecutionTimeM3(arrNum1, arrNum2, arrNum3);
            count++;
        }
        double[] doubles = new double[arraySizes.length];
        for (int i = 0; i < arraySizes.length; i++) {
            doubles[i] = arraySizes[i];
        }
        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();
        // add a line plot to the PlotPanel
        plot.addLinePlot("Insertion Sort", Color.red, doubles, doubleIS);
        plot.addLinePlot("Merge Sort", Color.green, doubles, doubleMS);
        plot.addLinePlot("Heap Sort", Color.blue, doubles, doubleHS);
        plot.addLinePlot("In-Place Quick Sort", Color.yellow, doubles, doubleIP);
        plot.addLinePlot("Median-of-Three Quick Sort", Color.black, doubles, doubleM3);
        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    private static int[] getArray(int size) {
        Random r = new Random();
        int[] integers = new int[size];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = r.nextInt();
        }
        return integers;
    }

    //Insertion Sort
    private static long startInsertionSort(int[] numberArray) {
        long startTimeIS = System.nanoTime();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.performInsertionSort(numberArray);
        long endTimeIS = System.nanoTime();
        System.out.println("\n\nSorting using Insertion Sort:");
        for (int i : numberArray) {
            System.out.print(i + " ");
        }
        long execTimeIS = endTimeIS - startTimeIS;
        System.out.println("\nTime Taken for execution using Insertion Sort = " + execTimeIS + " nanoseconds");
        return execTimeIS;
    }

    //Merge Sort
    private static long startMergeSort(int[] numberArray) {
        long startTimeMS = System.nanoTime();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numberArray);
        long endTimeMS = System.nanoTime();
        System.out.println("\n\nSorting using Merge Sort:");
        for (int i : numberArray) {
            System.out.print(i + " ");
        }
        long execTimeMS = endTimeMS - startTimeMS;
        System.out.println("\nTime Taken for execution using Merge Sort = " + execTimeMS + " nanoseconds");
        return execTimeMS;
    }

    //Heap Sort
    private static long startHeapSort(int[] numberArray) {
        long startTimeHS = System.nanoTime();
        HeapSort heapSort = new HeapSort();
        heapSort.performHeapSort(numberArray);
        long endTimeHS = System.nanoTime();
        System.out.println("\n\nSorting using Heap Sort:");
        for (int i : numberArray) {
            System.out.print(i + " ");
        }
        long execTimeHS = endTimeHS - startTimeHS;
        System.out.println("\nTime Taken for execution using Heap Sort = " + execTimeHS + " nanoseconds");
        return execTimeHS;
    }

    //In-Place Quick Sort
    private static long startInPlaceQuickSort(int[] numberArray) {
        long startTimeIP = System.nanoTime();
        InPlaceQuickSort inPlaceQuickSort = new InPlaceQuickSort();
        inPlaceQuickSort.performInPlaceQuickSort(numberArray);
        long endTimeIP = System.nanoTime();
        System.out.println("\n\nSorting using In-Place Quick Sort:");
        for (int i : numberArray) {
            System.out.print(i + " ");
        }
        long execTimeIP = endTimeIP - startTimeIP;
        System.out.println("\nTime Taken for execution using In-Place Quick Sort = " + execTimeIP + " nanoseconds");
        return execTimeIP;
    }

    //Median-of-Three Quick Sort
    private static long startMedianOfThreeQuickSort(int[] numberArray) {
        long startTimeM3 = System.nanoTime();
        MedianOfThreeQuickSort medianOfThreeQuickSort = new MedianOfThreeQuickSort();
        medianOfThreeQuickSort.performSort(numberArray);
        long endTimeM3 = System.nanoTime();
        System.out.println("\n\nSorting using Median-of-Three Quick Sort:");
        for (int i : numberArray) {
            System.out.print(i + " ");
        }
        long execTimeM3 = endTimeM3 - startTimeM3;
        System.out.println("\nTime Taken for execution using Median-of-Three Quick Sort = " + execTimeM3 + " nanoseconds");
        return execTimeM3;
    }

    private static long getExecutionTimeIS(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        int[] arrInsertionSort1 = Arrays.copyOf(arrNum1, arrNum1.length);
        int[] arrInsertionSort2 = Arrays.copyOf(arrNum2, arrNum2.length);
        int[] arrInsertionSort3 = Arrays.copyOf(arrNum3, arrNum3.length);
        return (startInsertionSort(arrInsertionSort1) + startInsertionSort(arrInsertionSort2) + startInsertionSort(arrInsertionSort3)) / 3;
    }

    private static long getExecutionTimeMS(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        int[] arrMergeSort1 = Arrays.copyOf(arrNum1, arrNum1.length);
        int[] arrMergeSort2 = Arrays.copyOf(arrNum2, arrNum2.length);
        int[] arrMergeSort3 = Arrays.copyOf(arrNum3, arrNum3.length);
        return (startMergeSort(arrMergeSort1) + startMergeSort(arrMergeSort2) + startMergeSort(arrMergeSort3)) / 3;
    }

    private static long getExecutionTimeHS(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        int[] arrHeapSort1 = Arrays.copyOf(arrNum1, arrNum1.length);
        int[] arrHeapSort2 = Arrays.copyOf(arrNum2, arrNum2.length);
        int[] arrHeapSort3 = Arrays.copyOf(arrNum3, arrNum3.length);
        return (startHeapSort(arrHeapSort1) + startHeapSort(arrHeapSort2) + startHeapSort(arrHeapSort3)) / 3;
    }

    private static long getExecutionTimeIP(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        int[] arrInPlaceQuickSort1 = Arrays.copyOf(arrNum1, arrNum1.length);
        int[] arrInPlaceQuickSort2 = Arrays.copyOf(arrNum2, arrNum2.length);
        int[] arrInPlaceQuickSort3 = Arrays.copyOf(arrNum3, arrNum3.length);
        return (startInPlaceQuickSort(arrInPlaceQuickSort1) + startInPlaceQuickSort(arrInPlaceQuickSort2) + startInPlaceQuickSort(arrInPlaceQuickSort3)) / 3;
    }

    private static long getExecutionTimeM3(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        int[] arrMedianOfThreeQuickSort1 = Arrays.copyOf(arrNum1, arrNum1.length);
        int[] arrMedianOfThreeQuickSort2 = Arrays.copyOf(arrNum2, arrNum2.length);
        int[] arrMedianOfThreeQuickSort3 = Arrays.copyOf(arrNum3, arrNum3.length);
        return (startMedianOfThreeQuickSort(arrMedianOfThreeQuickSort1) + startMedianOfThreeQuickSort(arrMedianOfThreeQuickSort2) + startMedianOfThreeQuickSort(arrMedianOfThreeQuickSort3)) / 3;
    }

    private static void sortArrayAscending(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        performAscendingSort(arrNum1);
        performAscendingSort(arrNum2);
        performAscendingSort(arrNum3);
    }

    private static void sortArrayDescending(int[] arrNum1, int[] arrNum2, int[] arrNum3) {
        performDescendingSort(arrNum1);
        performDescendingSort(arrNum2);
        performDescendingSort(arrNum3);
    }

    private static void performAscendingSort(int[] intArray) {
        InPlaceQuickSort inPlaceQuickSort = new InPlaceQuickSort();
        inPlaceQuickSort.performInPlaceQuickSort(intArray);
    }

    private static void performDescendingSort(int[] intArray) {
        InPlaceQuickSort inPlaceQuickSort = new InPlaceQuickSort();
        inPlaceQuickSort.performInPlaceQuickSort(intArray);
        for (int i = 0; i < intArray.length / 2; i++) {
            int temp = intArray[i];
            intArray[i] = intArray[intArray.length - i - 1];
            intArray[intArray.length - i - 1] = temp;
        }
    }
}
