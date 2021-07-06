package com.training.micro.person;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//@Repository
public interface IPersonDao extends CrudRepository<Person, Long> {

    // Mono<Person> findByNameAndSurname(String name);

    List<Person> findByName(String name);

    // Future<List<Person>> findByName(String name);

    //    Flux<Person> findByNameEx(String name);

    List<Person> findByNameAndSurname(String name,
                                      String surname);

    List<Person> findByNameAndSurnameOrderByName(String name,
                                                 String surname);

    List<Person> findByNameIn(List<String> name);

    @Query("select p from Person p where p.name=:isim")
    List<Person> searchName(@Param("isim") String abc);

    @Query("select p from Person p where p.name=?1 and p.surname=?2")
    List<Person> searchNameAndSurname(String name,
                                      String surname);

    @Query(value = "select * from person p where p.name=:isim", nativeQuery = true)
    List<Person> searchNameNative(@Param("isim") String abc);

    @Modifying
    @Query("update Person p set p.weight=?1 where p.personId=?2")
    void updateWeight(int we,
                      long personId);

}
