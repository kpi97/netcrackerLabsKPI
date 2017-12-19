package ru.vsu.netcracker.comparators.comparatorImpl;

import ru.vsu.netcracker.comparators.IComparator;
import ru.vsu.netcracker.models.Person;

public class ComparePersonById implements IComparator {
    public int compare(Object o1, Object o2) {
        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        int id1 = p1.getId();
        int id2 = p2.getId();

        if (id1 > id2) {
            return 1;
        } else if (id1 < id2){
            return -1;
        } else {
            return 0;
        }
    }
}
