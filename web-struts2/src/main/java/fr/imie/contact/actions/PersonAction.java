package fr.imie.contact.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.LocaleProvider;
import fr.imie.contact.DateUtils;
import fr.imie.contact.entities.*;
import fr.imie.contact.repositories.*;

import javax.inject.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class PersonAction extends ActionSupport {
    @Inject
    private Person person;
    private List<Person> persons;
    private PersonRepository repository = new PersonRepositoryMock();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public PersonAction() {
    }

    public String save() {
        repository.save(person);
        return SUCCESS;
    }

    public String deleteById() {
        //TODO recup id
        repository.deleteById(id);

        return SUCCESS;
    }

    public String findAll() {

        persons = repository.findAll();

        return SUCCESS;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
