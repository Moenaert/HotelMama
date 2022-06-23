package com.gilles.hotelmama;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

@Entity
@Table(name="ToDoes")
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

}
