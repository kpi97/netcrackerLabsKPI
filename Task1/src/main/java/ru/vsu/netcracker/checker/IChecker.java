package ru.vsu.netcracker.checker;

import ru.vsu.netcracker.models.Person;

public interface IChecker<T> {
    public boolean check(T item, Object obj);
}
