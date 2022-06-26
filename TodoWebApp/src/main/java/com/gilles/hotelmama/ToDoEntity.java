package com.gilles.hotelmama;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Entity
@Table(name="to_does")
public class ToDoEntity {
    @Id
//    @SequenceGenerator(name="mysequence", initialValue=1, allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String name;
    protected String description;

    //Depending on TemporalType here we can choose between:
    //Time,Timestamp,Date
    @Temporal(TemporalType.TIMESTAMP)
    protected Date targetDate;
    protected boolean isDone;

    @Transient //Prevents the mapping of a JavaBean property/type to Database representation.
    @XmlTransient //Prevents the mapping of a JavaBean property/type to XML representation.
    protected boolean ignore_Dummy;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ToDos")
    private List<User> Users = new ArrayList<>();

    public Collection<UserToDosDos> getKeys() {
        return keys;
    }

    public void setKeys(Collection<UserToDosDos> keys) {
        this.keys = keys;
    }

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL)
    private Collection<UserToDosDos> keys=new ArrayList<>();
    public ToDoEntity() {
    }

    public ToDoEntity(Long id, String name, String description, Date targetDate, boolean isDone) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isIgnore_Dummy() {
        return ignore_Dummy;
    }

    public void setIgnore_Dummy(boolean ignore_Dummy) {
        this.ignore_Dummy = ignore_Dummy;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
    }
}
