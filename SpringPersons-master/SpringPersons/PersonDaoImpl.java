package be.intecbrussel.springpersons.dao;

import be.intecbrussel.springpersons.services.implementations.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mockDao")
public class PersonDaoImpl implements PersonDao {

    private List<Person> personDB;

    public PersonDaoImpl() {
        personDB = new ArrayList<Person>();
    }

    @Override
    public List<Person> readAllPersons() {
        return personDB;
    }

    @Override
    public boolean createPerson(Person person) {
        personDB.add(person);
        System.out.println("Person with id: " + person.getId() + " constructed in the database");
        return true;
    }

    @Override
    public Person readPerson(int idPerson) {
        return personDB.get(idPerson);
    }

    @Override
    public boolean updatePerson(int idToUpdate, Person person) {
        Person personToUpdate = personDB.stream()
                .filter(personToSearch -> (idToUpdate == personToSearch.getId()))
                .findAny()
                .orElse(null);
        if (!personToUpdate.equals(null)) {
            personDB.remove(personToUpdate);
            personDB.add(person);
            System.out.println("\n\nPerson id: " + idToUpdate + " updated in the database");
            return true;
        } else {
            System.out.println("Person to update not found...........");
            return false;
        }
    }


    @Override
    public boolean deletePerson(Person person) {
        personDB.remove(person.getId());
        System.out.println("\n\nPerson id: " + person.getId() + " deleted from the database");
        return true;
    }
}





