package fr.imie.contact.repositories;

import fr.imie.contact.entities.BankAccount;
import fr.imie.contact.entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BankAccountRepository {
    @PersistenceContext
    private EntityManager em;

    public List<BankAccount> findAll() {
        return em.createQuery("select ba from BankAccount ba", BankAccount.class).getResultList();
    }

    public BankAccount findById(Integer id) {
        return em.find(BankAccount.class, id);
    }



    public void save(BankAccount bankAccount) {
        if (bankAccount.getId() == null) {
            em.persist(bankAccount);
        }else {
            em.merge(bankAccount);
        }    }
}
