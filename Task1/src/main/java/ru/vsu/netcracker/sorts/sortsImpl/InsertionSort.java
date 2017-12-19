package ru.vsu.netcracker.sorts.sortsImpl;

import ru.vsu.netcracker.comparators.IComparator;
import ru.vsu.netcracker.sorts.ISort;

/**
 * Class implements {@link ISort} and implements insertion sort
 * @author Pavel Kuchinsky
 * @version 1.0
 */
public class InsertionSort implements ISort {
    public <T> T[] sort(T[] array, IComparator comparator) {
        int n = array.length;
        for (int i = 0; i < n; i ++) {
            int minIndex = min(array, i,n - 1, comparator);
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public <T> int min(T[] array, int begin, int end, IComparator comparator) {
        T minVal = array[begin];
        int minIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (comparator.compare(array[i], minVal) < 0) {
                minVal = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
