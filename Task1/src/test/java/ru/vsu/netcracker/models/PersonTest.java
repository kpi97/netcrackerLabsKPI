package ru.vsu.netcracker.models;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void getAge1() throws Exception {
        Person person = new Person("Kuchinsky", new LocalDate("1997-12-17"));
        int expectedAge = 20;
        int age = person.getAge();

        assertEquals(expectedAge, age);
    }

    @Test
    public void getAge2() throws Exception {
        Person person = new Person("Ivanov", new LocalDate("1997-12-30"));
        int expectedAge = 19;
        int age = person.getAge();

        assertEquals(expectedAge, age);
    }
}