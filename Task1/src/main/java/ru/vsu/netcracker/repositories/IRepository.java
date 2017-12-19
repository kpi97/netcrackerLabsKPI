package ru.vsu.netcracker.repositories;

public interface IRepository<T> {

    int getCurrentSize();

    void clear();

    boolean isEmpty();

    void add(T obj);

    boolean delete(T obj);

    boolean contains(T obj);

    T[] getRepository();
}
