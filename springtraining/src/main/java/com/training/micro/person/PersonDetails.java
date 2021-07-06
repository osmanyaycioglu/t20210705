package com.training.micro.person;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PersonDetails {

    private String  text;
    @Enumerated(EnumType.STRING)
    private EGender gender;


    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String textParam) {
        this.text = textParam;
    }


}
