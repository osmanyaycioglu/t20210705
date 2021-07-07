package com.training.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private IPersonDao pDao;


    public void add(final Person person) {
        this.pDao.save(person);
    }

}
