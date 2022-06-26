package com.gilles.hotelmama;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String password;
    private String name;

    public User() {
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_to_dos",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "to_do_id")})
    private List<ToDoEntity> ToDos = new ArrayList<ToDoEntity>();

    public Collection<UserToDosDos> getKeys() {
        return keys;
    }

    public void setKeys(Collection<UserToDosDos> keys) {
        this.keys = keys;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<UserToDosDos> keys = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToDoEntity> getToDos() {
        return ToDos;
    }

    public void setToDos(List<ToDoEntity> toDos) {
        ToDos = toDos;
    }
}
