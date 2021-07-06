package com.training.micro.person;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonRest {

    @Autowired
    private PersonManager pm;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        person.getAddress()
              .setPerson(person);
        Set<Phone> phoneLoc = person.getPhone();
        for (Phone phone2Loc : phoneLoc) {
            phone2Loc.setPerson(person);
        }
        this.pm.add(person);
        return "SUCCESS";
    }

    @GetMapping("/get/{perId}")
    public Person get(@PathVariable("perId") final Long personId) {
        return this.pm.getPerson(personId);
    }

    @GetMapping("/get2")
    public Person get2(@RequestParam("perId") final Long personId) {
        return this.pm.getPerson(personId);
    }

    @GetMapping("/dyn/{cmd}")
    public Person dyn(@PathVariable("cmd") final String command,
                      final HttpServletRequest requestParam) {
        switch (command) {
            case "add": {
                String parameterLoc = requestParam.getParameter("xyz");
                String abcLoc = requestParam.getParameter("abc");
                // do something
                break;
            }
            case "delete": {
                String parameterLoc = requestParam.getParameter("xyz");
                // do something
                break;
            }
            default:
                break;
        }
        return null;
    }

}
