package be.intecbrussel.springpersons.configuration;

import be.intecbrussel.springpersons.dao.PersonDao;
import be.intecbrussel.springpersons.services.PersonService;
import be.intecbrussel.springpersons.services.implementations.PersonServiceImpl;
import be.intecbrussel.springpersons.model.Person;
import org.springframework.context.annotation.*;

import java.time.LocalDate;

@Configuration
@ComponentScan(basePackages = "be.intecbrussel.springpersons")
public class SpringPersonsConfiguration {
    private int id;

    @Bean
    @Scope("prototype")
    public Person personFactoryMethod(){
       return null;
    }



    }



