package fr.imie.contact.repositories;

import fr.imie.contact.entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Person> findAll() {
        return em
                .createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    public Person findById(Integer id) {
        return em.find(Person.class, id);
    }

    public void save(Person person) {
        em.persist(person);
    }

}
