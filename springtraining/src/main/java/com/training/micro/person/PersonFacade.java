package com.training.micro.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonFacade {

    @Autowired
    private IPersonDao pDao;

    public void add(final Person person) {

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save1(final Person personParam) {
        this.pDao.save(personParam);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save2(final Person personParam) {
        this.pDao.save(personParam);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save3(final Person personParam) {
        this.pDao.save(personParam);

    }

    public void deleteById(final Long perIdParam) {
        this.pDao.deleteById(perIdParam);

    }

    public Person findById(final Long perIdParam) {
        return this.pDao.findById(perIdParam)
                        .orElse(null);
    }

}
