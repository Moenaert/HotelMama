package com.gilles.hotelmama;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Person {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // standard getters, setters
}
