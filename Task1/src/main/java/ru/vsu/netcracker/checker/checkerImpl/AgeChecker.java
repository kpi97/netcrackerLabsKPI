package ru.vsu.netcracker.checker.checkerImpl;

import ru.vsu.netcracker.checker.IChecker;
import ru.vsu.netcracker.models.Person;

public class AgeChecker implements IChecker<Person> {
    @Override
    public boolean check(Person person, Object obj) {
        return person.getAge() == (int)obj;
    }
}
