package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;

import java.util.*;

public class PersonRepositoryMock extends PersonRepository {

    //  private List persons = new ArrayList();
    private Map persons = new TreeMap();

    private static int autoIncrement = 1;

    public PersonRepositoryMock() {
        save(new Person("anakin", "skywalkerrr"));
        save(new Person("luke", "skywalker"));
        save(new Person("leia", "organa"));
    }

    public List<Person> findAll() {
        return new ArrayList(persons.values());

    }

    public void save(Person person) {
        persons.put(autoIncrement, person);
        person.setId(autoIncrement);
        autoIncrement++;
    }

    public void deleteById(int id) {
        persons.remove(id);
    }

}
