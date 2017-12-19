package ru.vsu.netcracker.checker.checkerImpl;

import ru.vsu.netcracker.checker.IChecker;
import ru.vsu.netcracker.models.Car;

public class ModelCarChecker implements IChecker<Car> {
    @Override
    public boolean check(Car car, Object obj) {
        return car.getModel().equals(obj);
    }
}
