package be.intecbrussel.springpersons.services.implementations;

import be.intecbrussel.springpersons.dao.implementations.PersonDaoImpl;
import be.intecbrussel.springpersons.model.Person;
import be.intecbrussel.springpersons.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mockService")
public class PersonServiceImpl implements PersonService {


    @Autowired
    PersonDaoImpl personDao;

    List<Person> allPersons=new ArrayList<>();



    @Override
    public Person getPerson(int idPerson) {
        return personDao.readAllPersons().get(idPerson);
    }

    @Override
    public void addPerson(Person person) {
        personDao.readAllPersons().add(person);
        personDao.createPerson(person);
        allPersons.add(person);
    }

    @Override
    public void addPersons(List<Person> personList) {
    }


    @Override
    public List<Person> getAllPersons() {
        return allPersons;
    }
}
