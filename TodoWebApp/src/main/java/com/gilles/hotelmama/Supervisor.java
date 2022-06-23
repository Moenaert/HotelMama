package com.gilles.hotelmama;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.List;

@Entity
@Table(name = "Supervisor")
public class Supervisor {

    public Supervisor() {
    }

    @Id
    @GeneratedValue
    private Long id;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Embedded
    private Person person;

    @Enumerated(EnumType.STRING)
    public Role role;

    @OneToMany(targetEntity = User.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name="User_fk",referencedColumnName = "id")
    private List<User> Users;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
