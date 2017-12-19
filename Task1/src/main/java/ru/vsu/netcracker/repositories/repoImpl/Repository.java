package ru.vsu.netcracker.repositories.repoImpl;

import ru.vsu.netcracker.comparators.IComparator;
import ru.vsu.netcracker.repositories.IRepository;
import ru.vsu.netcracker.sorts.ISort;

/**
 * <b>maxSize</b> - max size of array
 * <b>personList</b> - array for storing persons
 * <b>tail</b> - index of last item in array
 * @param <T>
 */
public abstract class Repository<T> implements IRepository<T> {

    protected int maxSize;
    protected T[] list;
    protected int tail;

    /**
     * Method for adding new obj to list
     * @param obj
     */
    @Override
    public void add(T obj) {
        if (!isFull()) {
            list[++tail] = obj;
        }
        else {
            T[] newList = (T[])new Object[maxSize * 2];
            for (int i = 0; i <= tail; i++) {
                newList[i] = list[i];
            }
            list = (T[])newList;
            maxSize = maxSize * 2;
            list[++tail] = (T)obj;
        }
    }

    /**
     * Method for deleting from list
     * @param obj
     * @return true if obj was delete find and delete, else false
     */
    @Override
    public boolean delete(T obj) {
        if (!isEmpty()) {
            int j = -1;
            boolean fl = false;

            for (int i = 0; i <= tail; i++){
                if (list[i].equals(obj)){
                    j = i;
                    fl = true;
                    break;
                }
            }

            if (fl){
                for (int i = j + 1; i <= tail; i++){
                    list[i - 1] = list[i];
                }
                list[tail] = null;
                tail--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] getRepository() {
        return (T[])list;
    }

    /**
     * method for sorting list
     * @param typeOfSort - selected sort
     * @param comparator - custom comparator by selected field
     * {@link ISort}
     * {@link IComparator}
     */
    protected void sort(ISort typeOfSort, IComparator comparator){
        typeOfSort.sort(list, comparator);
    }

    public int getCurrentSize() {
        return tail + 1;
    }

    /**
     * Method checks if list is empty
     * @return true if list is empty, else false
     */
    public boolean isEmpty(){
        return (tail == -1);
    }

    /**
     * Method checks if list is full
     * @return true if list is full, else false
     */
    protected boolean isFull(){
        return (tail == maxSize - 1);
    }

    public abstract void clear();

    /**
     * Method checks if list contains obj
     * @return true if list contains it, else false
     */
    public boolean contains(T obj) {
        for (int i = 0; i < tail; i++){
            if (list[i].equals(obj)){
                return true;
            }
        }
        return false;
    }
}
