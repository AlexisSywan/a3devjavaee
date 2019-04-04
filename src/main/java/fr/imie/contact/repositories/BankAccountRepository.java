package fr.imie.contact.repositories;

import fr.imie.contact.entities.BankAccount;

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


    public void save(BankAccount bankAccount) {
        em.persist(bankAccount);
    }
}
