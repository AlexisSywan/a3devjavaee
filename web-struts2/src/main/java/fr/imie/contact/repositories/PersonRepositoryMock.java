package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;

import java.util.*;

public class PersonRepositoryMock extends PersonRepository {

    //  private List persons = new ArrayList();
    private static Map persons = new TreeMap();

    private static int autoIncrement = 1;

    static {
        PersonRepositoryMock mock = new PersonRepositoryMock();
        mock.save(new Person("anakin", "skywalkerrr"));
        mock.save(new Person("luke", "skywalker"));
        mock.save(new Person("leia", "organa"));
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
