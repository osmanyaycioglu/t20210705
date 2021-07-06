package com.training.micro.person;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
//@Table(schema = "sema1")
public class Person {

    @Id
    @GeneratedValue
    private Long          personId;
    @NotEmpty
    @Size(min = 2, max = 20, message = "isim 2 ile 20 arasında olmalı")
    @Column(name = "isim")
    private String        name;
    @NotEmpty
    @Size(min = 2, max = 20, message = "soyisim 2 ile 20 arasında olmalı")
    @StartWith("sur:")
    private String        surname;
    @Email
    // @Pattern("")
    private String        email;
    @Max(300)
    @Min(10)
    private int           weight;
    @Max(250)
    @Min(50)
    private int           height;

    @Embedded
    private PersonDetails personDetails;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
    private Address       address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "person")
    private Set<Phone>    phone;

    private long          updateDate;

    @Version
    private long          personVersion;

    @PrePersist
    @PreUpdate
    public void pres() {
        // this.surname = this.surname.substring(4);
        System.out.println("Pre Save");
        this.updateDate = System.currentTimeMillis();
    }

    @PreRemove
    public void preRem() {
        System.out.println("Pre Remove");
    }

    @PostPersist
    @PostUpdate
    public void posts() {
        System.out.println("Post Save");
    }

    @PostRemove
    public void postRem() {
        System.out.println("Post Remove");
    }

    @PostLoad
    public void pLoad() {
        System.out.println("Post Load");
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weightParam) {
        this.weight = weightParam;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int heightParam) {
        this.height = heightParam;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    public PersonDetails getPersonDetails() {
        return this.personDetails;
    }

    public void setPersonDetails(final PersonDetails personDetailsParam) {
        this.personDetails = personDetailsParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public Set<Phone> getPhone() {
        return this.phone;
    }

    public void setPhone(final Set<Phone> phoneParam) {
        this.phone = phoneParam;
    }

    public long getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(final long updateDateParam) {
        this.updateDate = updateDateParam;
    }

    public long getPersonVersion() {
        return this.personVersion;
    }

    public void setPersonVersion(final long personVersionParam) {
        this.personVersion = personVersionParam;
    }


}
