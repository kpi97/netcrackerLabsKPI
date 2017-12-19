package ru.vsu.netcracker.comparators.comparatorImpl;

import ru.vsu.netcracker.comparators.IComparator;
import ru.vsu.netcracker.models.Person;

public class CompareByFIO implements IComparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        return p1.getLastName().compareTo(p2.getLastName());
    }
}
