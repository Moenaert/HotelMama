package com.gilles.hotelmama;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Person person;

    public User() {
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "User_ToDos",
            joinColumns = {@JoinColumn(name = "User_id")},
            inverseJoinColumns = {@JoinColumn(name = "ToDo_id")})
    private List<ToDoEntity> ToDos = new ArrayList<ToDoEntity>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
