package ru.vsu.netcracker.checker.checkerImpl;

import ru.vsu.netcracker.checker.IChecker;
import ru.vsu.netcracker.models.Car;

public class EnginePowerChecker implements IChecker<Car> {
    @Override
    public boolean check(Car car, Object obj) {
        return car.getEnginePower() == (double)obj;
    }
}
