package com.training.micro.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonManager {

    @Autowired
    private PersonFacade pDao;


    @Transactional(propagation = Propagation.REQUIRED)
    public void add(final Person person) {
        this.pDao.save1(person);
        //        this.pDao.save2(person);
        //        this.pDao.save3(person);
    }

    public void delete(final Long perId) {
        this.pDao.deleteById(perId);
    }

    public void update(final Person person) {
        this.pDao.save1(person);
    }

    public Person getPerson(final Long perId) {
        return this.pDao.findById(perId);
    }

    public static void main(final String[] args) {
        PersonManager managerLoc = new PersonManagerProxy(new PersonManager());
        managerLoc.add(null);

    }

}
