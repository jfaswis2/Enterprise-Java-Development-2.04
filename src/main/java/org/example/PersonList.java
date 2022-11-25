package org.example;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.List;

public class PersonList {
    List<Person> personList;

    public PersonList() {
        this.personList = new ArrayList<>();
        personList.add(new Person(1,"Jhon Aristizabal", 25,"Student"));
    }

    public Person findByName(String name) throws InvalidNameException {
        String[] nameSplit = name.split(" ");
        if (nameSplit.length != 2){
            throw new IllegalArgumentException("El nombre debe de tener nombre y apellido");
        }
        for (Person p: personList) {
            if (p.getName().equals(name)){
                return p;
            }
        }
        throw new IllegalArgumentException("El nombre no aparece en la lista");
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(Person person) {
        personList.add(person);
    }
}
