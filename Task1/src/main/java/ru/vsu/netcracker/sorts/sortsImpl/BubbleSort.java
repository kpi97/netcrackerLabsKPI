package ru.vsu.netcracker.sorts.sortsImpl;

import ru.vsu.netcracker.comparators.IComparator;
import ru.vsu.netcracker.sorts.ISort;

/**
 * Class implements {@link ISort} and implements bubble sort
 * @author Pavel Kuchinsky
 * @version 1.0
 */
public class BubbleSort implements ISort {
    public <T> T[] sort(T[] array, IComparator comparator) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1; j++)
            {
                if (comparator.compare(array[j], array[j + 1]) > 0)
                {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        return  array;
    }
}
