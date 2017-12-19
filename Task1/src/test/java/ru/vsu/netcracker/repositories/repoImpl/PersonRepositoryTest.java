package ru.vsu.netcracker.repositories.repoImpl;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.vsu.netcracker.comparators.comparatorImpl.CompareByDateOfBirth;
import ru.vsu.netcracker.comparators.comparatorImpl.CompareByFIO;
import ru.vsu.netcracker.models.Person;
import ru.vsu.netcracker.repositories.repoImpl.PersonRepository;
import ru.vsu.netcracker.sorts.sortsImpl.BubbleSort;
import ru.vsu.netcracker.sorts.sortsImpl.InsertionSort;
import ru.vsu.netcracker.sorts.sortsImpl.QuickSort;

import static org.junit.Assert.*;

public class PersonRepositoryTest {
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;


    @Before
    public void init() throws Exception {
        person1 = new Person("Arshavin", new LocalDate("1997-02-20"));      //lastname - 1 age - 3
        person2 = new Person("Chelyadinov", new LocalDate("1990-01-01"));   //lastname - 3 age - 2
        person3 = new Person("Dimitrov", new LocalDate("1970-08-18"));      //lastname - 4 age - 1
        person4 = new Person("Bukharin", new LocalDate("2000-08-22"));      //lastname - 2 age - 4

    }

    @After
    public void destroy() throws Exception {
        person1 = null;
        person2 = null;
        person3 = null;
        person4 = null;
    }

    @Test
    public void add() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(2);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);

        Person[] expectedPersonRepository = new Person[4];
        expectedPersonRepository[0] = person1;
        expectedPersonRepository[1] = person2;
        expectedPersonRepository[2] = person3;
        expectedPersonRepository[3] = person4;

        assertArrayEquals(expectedPersonRepository, actualPersonRepository.getRepository());
    }

    @Test
    public void getCurrentSize() throws Exception {
        PersonRepository personRepository = new PersonRepository(2);
        personRepository.add(person1);
        personRepository.add(person2);
        personRepository.add(person3);
        personRepository.add(person4);

        int expectedSize = 4;
        int actualSize = personRepository.getCurrentSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void deletePerson() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(2);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);


        actualPersonRepository.delete(person2);
        actualPersonRepository.delete(person3);

        PersonRepository expectedPersonRepository = new PersonRepository(4);
        expectedPersonRepository.add(person1);
        expectedPersonRepository.add(person4);


        Object[] actPers = actualPersonRepository.getRepository();
        Object[] expPers = expectedPersonRepository.getRepository();

        assertArrayEquals(expPers, actPers);
    }

    @Test
    public void deletePersonFalse() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(2);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);
        boolean del = actualPersonRepository.delete(new Person());

        assertEquals(false, del);
    }

    @Test
    public void sortByFio() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(4);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);
        actualPersonRepository.sortByFio();

        PersonRepository expectedPersonRepository = new PersonRepository(4);
        expectedPersonRepository.add(person1);
        expectedPersonRepository.add(person4);
        expectedPersonRepository.add(person2);
        expectedPersonRepository.add(person3);

        Object[] actPers = actualPersonRepository.getRepository();
        Object[] expPers = expectedPersonRepository.getRepository();

        assertArrayEquals(expPers, actPers);
    }

    @Test
    public void sortByDateOfBirth() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(4);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);
        actualPersonRepository.sortByDateOfBirth();

        PersonRepository expectedPersonRepository = new PersonRepository(4);
        expectedPersonRepository.add(person3);
        expectedPersonRepository.add(person2);
        expectedPersonRepository.add(person1);
        expectedPersonRepository.add(person4);

        Object[] actPers = actualPersonRepository.getRepository();
        Object[] expPers = expectedPersonRepository.getRepository();

        assertArrayEquals(expPers, actPers);
    }

    @Test
    public void sortById() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(4);
        actualPersonRepository.add(person4);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person1);
        actualPersonRepository.sortById();

        PersonRepository expectedPersonRepository = new PersonRepository(4);
        expectedPersonRepository.add(person1);
        expectedPersonRepository.add(person2);
        expectedPersonRepository.add(person3);
        expectedPersonRepository.add(person4);


        Object[] actPers = actualPersonRepository.getRepository();
        Object[] expPers = expectedPersonRepository.getRepository();

        assertArrayEquals(expPers, actPers);
    }

    @Test
    public void getPersonById() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(4);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);
        int index = person3.getId();

        Person actPers = actualPersonRepository.getPersonById(index);
        Person expPers = person3;

        assertEquals(expPers, actPers);
    }

    @Test
    public void getPersonByIdNull() throws Exception {
        PersonRepository actualPersonRepository = new PersonRepository(4);
        actualPersonRepository.add(person2);
        actualPersonRepository.add(person1);
        actualPersonRepository.add(person3);
        actualPersonRepository.add(person4);

        Person actPers = actualPersonRepository.getPersonById(10);
        Person expPers = null;

        assertEquals(expPers, actPers);
    }

}