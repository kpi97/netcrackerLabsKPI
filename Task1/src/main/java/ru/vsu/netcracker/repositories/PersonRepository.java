package ru.vsu.netcracker.repositories;

import ru.vsu.netcracker.models.Person;

import java.util.List;

public class PersonRepository {

    private int maxSize;
    private Person[] personList;
    private int last;
    private int step=10;

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public PersonRepository(int size) {
        maxSize = size;
        personList = new Person[maxSize];
        last = -1;
    }
    public PersonRepository(int size, int step) {
        maxSize = size;
        personList = new Person[maxSize];
        last = -1;
        this.step = step;
    }


    public void add(Person person){

        if (last<maxSize-1) {
            personList[++last] = person;
        }
        else {
            maxSize = maxSize +step;
            Person[] newList = new Person[maxSize];
            for (int i = 0; i <= last; i++) {
                newList[i] = personList[i];
            }
            personList = null;
            personList = newList;
            personList[++last] = person;
        }
    }

    public boolean deletePerson(int id){
        if (last>=0) {
            int j = -1;
            boolean flag = false;

            for (int i = 0; i <= last; i++){
                if (personList[i].getId() == id){
                    j = i;
                    flag = true;
                    break;
                }
            }

            if (flag){
                for (int i = j + 1; i <= last; i++){
                    personList[i - 1] = personList[i];
                }
                personList[maxSize - 1] = null;
                last--;
                return true;
            }
            return false;
        }

        return false;
    }

    public Person getPersonById(int id) {

        for (int i = 0; i <= last; i++) {
            if (personList[i].getId() == id) {
                return personList[i];
            }
        }
        return null;
    }
    public PersonRepository getPersonByLastName(String personLastName)
    {
        PersonRepository repository = new PersonRepository(0,1);
        for (int i = 0; i<=last; i++) {
           if (personList[i].getLastName().equals(personLastName))
                repository.add(personList[i]);
        }
        return repository;
    }

    public PersonRepository getPersonByAge(int age)
    {
        PersonRepository repository = new PersonRepository(0,1);
        for (int i = 0; i <= last; i++){
            if (personList[i].getAge()==age)
                repository.add(personList[i]);
        }
        return repository;
    }

    @Override
    public String toString() {
        String string="";
        for (int i = 0; i<=last;i++){
            string+=personList[i].toString()+"\n";
        }
        return string;
    }

    public int getCurrentSize() {
        return last + 1;
    }

}
