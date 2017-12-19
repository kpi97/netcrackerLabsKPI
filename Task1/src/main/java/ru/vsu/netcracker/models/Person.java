package ru.vsu.netcracker.models;

import org.joda.time.*;

/**
 * Class of person with fields: <b>id</b> - autogenerate,
 * <b>lastName</b>, <b>dateOfBirth</b>
 *{@value} count - general number of existing instances of this class
 *@author Pavel Kuchinsky
 *@version 1.0
 */
public class Person {

    private static int count = 0;
    private int id;
    private String lastName;
    private LocalDate dateOfBirth;

    /**
     *@see Person#Person(String, LocalDate)
     */
    public Person() {
        id = count++;
    }

    /**
     * @param lastName
     * @param dateOfBirth
     * @see Person#Person()
     */
    public Person(String lastName, LocalDate dateOfBirth) {
        this.id = count++;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
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

    public Integer getAge(){
        LocalDate currentDate = new LocalDate();
        Period period = new Period(dateOfBirth, currentDate, PeriodType.yearMonthDay());
        return period.getYears();
    }

    public String toString(){
        return Person.class.getSimpleName() + "[id = " + getId() + ", Last name = " + getLastName()
                + ", date of birth = " + getDateOfBirth() + "]";
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return (person.id == this.id && person.lastName.equals(this.lastName)
                && person.dateOfBirth.equals(this.dateOfBirth));
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + (lastName == null ? 0 : lastName.hashCode());
        result = prime * result + (dateOfBirth == null ? 0: dateOfBirth.hashCode());
        return result;
    }
}

