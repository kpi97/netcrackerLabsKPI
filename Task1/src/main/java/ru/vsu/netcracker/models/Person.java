package ru.vsu.netcracker.models;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Person {

    private int id;
    private String lastName;
    private LocalDate dateOfBirth;
    private static int nextId=1;

    //public Person() {}

    public Person(String lastName, LocalDate dateOfBirth) {
        this.id = nextId++;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){
        LocalDate now=new LocalDate();
        int age=now.getYear()-dateOfBirth.getYear();
        if (now.getMonthOfYear()<dateOfBirth.getMonthOfYear())
            age=age-1;
        else if (now.getMonthOfYear()==dateOfBirth.getMonthOfYear() && now.getDayOfMonth()<=dateOfBirth.getDayOfMonth())
            age=age-1;
        return age;
    }

    public String toString(){
        return "id: " + getId() + "; Last name: " + getLastName()
                + "; date of birth: " + getDateOfBirth() + "; age: " + getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) {
            return false;
        }
        if (!lastName.equals(person.lastName)) {
            return false;
        }
        return dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        return result;
    }
}

