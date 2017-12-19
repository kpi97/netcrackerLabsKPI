package ru.vsu.netcracker.sorts;

import ru.vsu.netcracker.comparators.IComparator;

public interface ISort {
    <T> T[] sort(T[] array, IComparator comparator);
}
