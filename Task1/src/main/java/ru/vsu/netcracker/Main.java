package ru.vsu.netcracker;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import ru.vsu.netcracker.models.Person;
import ru.vsu.netcracker.repositories.PersonRepository;

public class Main {

    public static void main(String[] args){
        Person person1 = new Person("Ivanov", new LocalDate(1997,11,10));
        Person person2 = new Person("Kuchinsky", new LocalDate(1997,04,22));
        Person person3 = new Person("Ivanov", new LocalDate(1997,11,28));

        PersonRepository repository = new PersonRepository(0,5);
        repository.add(person1);
        repository.add(person2);
        repository.add(person3);

        /*System.out.println("Person with id = 1: "+repository.getPersonById(1));
        System.out.println("Person with id = 2: "+repository.getPersonById(2));
        System.out.println("Person with id = 3: "+repository.getPersonById(3));
        System.out.println("Person with id = 4: "+repository.getPersonById(4));

        System.out.println("Delete person with id = 1: "+repository.deletePerson(1));
        System.out.println("Delete person with id = 4: "+repository.deletePerson(4));

        System.out.println("Person with id = 1: "+repository.getPersonById(1));*/

        System.out.println("Search by Last name:Ivanov");
        PersonRepository repository1 = repository.getPersonByLastName("Ivanov");
        System.out.println(repository1.toString());

        System.out.println("Search by age: 20");
        PersonRepository repository2 = repository.getPersonByAge(20);
        System.out.println(repository2.toString());
    }
}
