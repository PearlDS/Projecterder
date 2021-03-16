package be.intecbrussel.springpersons.dao.implementations;

import be.intecbrussel.springpersons.dao.PersonDao;
import be.intecbrussel.springpersons.model.Person;
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
        personDB.remove(idToUpdate);
        personDB.add(person);
        System.out.println("\n\nPerson id: " + idToUpdate + " updated in the database");
        return true;
    }


    @Override
    public boolean deletePerson(Person person) {
        personDB.remove(person.getId());
        System.out.println("\n\nPerson id: " + person.getId() + " deleted from the database");
        return true;
    }
}

//    public void setPersonDB(List<Person> personDB) {
//        this.personDB = personDB;
//    }


//    public boolean updatePerson(Person person){
//
//        return true;
//    }

//    public boolean deletePerson(Person person){
//
//        return true;
//    }

//    public List<Person> readAllPersons(){
//        return new ArrayList<Person>();
//    }




