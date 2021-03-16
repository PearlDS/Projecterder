package be.intecbrussel.springpersons.services;

import be.intecbrussel.springpersons.model.Person;

import java.util.List;

public interface PersonService {
    Person getPerson(int idPerson);
    void addPerson(Person person);
    void addPersons(List<Person>personList);
    List<Person> getAllPersons();

}
