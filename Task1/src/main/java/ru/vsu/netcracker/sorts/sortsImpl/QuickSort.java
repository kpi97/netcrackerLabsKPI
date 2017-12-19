package ru.vsu.netcracker.sorts.sortsImpl;

import ru.vsu.netcracker.comparators.IComparator;
import ru.vsu.netcracker.sorts.ISort;

/**
 * Class implements {@link ISort} and implements quick sort
 * @author Pavel Kuchinsky
 * @version 1.0
 */
public class QuickSort implements ISort {
    public <T> T[] sort(T[] array, IComparator comparator) {
        qSort(array,0, array.length - 1, comparator);
        return array;
    }

    private <T> void qSort(T[] a, int l, int r, IComparator comparator) {
        int i=l, j=r;
        T x, temp;
        x = a[(l+r)/2];
        do
        {
            while (comparator.compare(a[i], x) < 0)
                i++;
            while (comparator.compare(x, a[j]) < 0)
                j--;
            if (i <= j)
            {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        } while( i <= j);
        if (l < j) qSort (a, l, j, comparator);
        if (r > i) qSort (a, i, r, comparator);
    }
}
