package be.intecbrussel.springpersons.dao;

import be.intecbrussel.springpersons.model.Person;

import java.util.List;

public interface PersonDao {

boolean createPerson(Person person);
Person readPerson(int id);
boolean updatePerson(int idToUpdate,Person person);
boolean deletePerson(Person person);
List<Person> readAllPersons();

}
