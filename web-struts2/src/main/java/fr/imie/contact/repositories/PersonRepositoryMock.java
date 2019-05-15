package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;
import java.util.*;

public class PersonRepositoryMock extends PersonRepository {

  private List persons = new ArrayList();

  public PersonRepositoryMock() {
    save(new Person("anakin", "skywalkerrr"));
    save(new Person("luke", "skywalker"));
    save(new Person("leia", "organa"));
  }

  public List<Person> findAll() {
    return persons;
  }

  public void save(Person person) {
    persons.add(person);
  }

}
