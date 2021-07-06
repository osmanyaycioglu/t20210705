package com.training.micro.person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonManagerProxy extends PersonManager {

    private final PersonManager pm;

    @PersistenceContext
    private EntityManager       eManager;

    public PersonManagerProxy(final PersonManager pmParam) {
        super();
        this.pm = pmParam;
    }

    @Override
    public void add(final Person person) {
        this.eManager.getTransaction()
                     .begin();
        try {
            this.pm.add(person);
            this.eManager.getTransaction()
                         .commit();
        } catch (Exception eLoc) {
            this.eManager.getTransaction()
                         .rollback();
        }
    }

    @Override
    public void delete(final Long perId) {
        this.pm.delete(perId);
    }

    @Override
    public void update(final Person person) {
        this.pm.update(person);
    }

    @Override
    public Person getPerson(final Long perId) {
        return this.pm.getPerson(perId);
    }


}
