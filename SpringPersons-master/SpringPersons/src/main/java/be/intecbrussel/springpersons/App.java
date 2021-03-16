package be.intecbrussel.springpersons;

import be.intecbrussel.springpersons.configuration.SpringPersonsConfiguration;
import be.intecbrussel.springpersons.dao.PersonDao;
import be.intecbrussel.springpersons.services.PersonService;
import be.intecbrussel.springpersons.model.Person;
import be.intecbrussel.springpersons.dao.implementations.PersonDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class App {

    private static PersonDao personDaoImpl;

    public static void main(String[] args) {

        personDaoImpl = new PersonDaoImpl();

        Person person1 = new Person("Johnson", LocalDate.of(1997, 11, 6), 1, "Richard");
        Person person2 = new Person("Locker", LocalDate.of(1989, 3, 25), 2, "Alina");
        Person person3 = new Person("Willems", LocalDate.of(1978, 4, 5), 3, "Conan");

//        Construction and printing the persons created
        System.out.println("Persons created initially:");
        boolean p1 = personDaoImpl.createPerson(person1);
        boolean p2 = personDaoImpl.createPerson(person2);
        boolean p3 = personDaoImpl.createPerson(person3);

//        Printing all persons
        System.out.println("\n\nAll persons listed:");
        personDaoImpl.readAllPersons().stream()
                .map(Person::toString)
                .forEach(System.out::println);


//        Updating the second person and printing the new list of persons
        Person personToUpdate=new Person("Dexter",LocalDate.of(1970,02,05),2,"James");
        personDaoImpl.updatePerson(1, personToUpdate);
        System.out.println("\nAll persons listed after this update:");
        personDaoImpl.readAllPersons().stream()
                .map(Person::toString)
                .forEach(System.out::println);


        personDaoImpl.deletePerson(person2);

        System.out.println(person1.toString());


        ApplicationContext context = new AnnotationConfigApplicationContext(SpringPersonsConfiguration.class);
        PersonService personService = context.getBean("mockService", PersonService.class);

        person1 = context.getBean("personFactoryMethod",Person.class);

        personService.addPerson(person3);
        personService.addPerson(person2);
        personService.addPerson(person1);

        System.out.println(personService.getPerson(1).toString());
        System.out.println(personService.getPerson(2).toString());
        System.out.println(personService.getPerson(3).toString());

        System.out.println("\n\nSecond person in the list is  " + personService.getPerson(2));

        Person personWithIdEqualsToTwo =
                personService.getAllPersons().stream()
                        .filter(persons -> (2 == persons.getId()))
                        .findAny()
                        .orElse(null);

        System.out.println("\n\nPerson with id equals to 2 is " + personWithIdEqualsToTwo);

    }

}
