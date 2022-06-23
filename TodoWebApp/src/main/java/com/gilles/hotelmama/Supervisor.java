package com.gilles.hotelmama;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supervisor")
public class Supervisor {

    public Supervisor() {
    }

    public Supervisor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;


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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
//
//    val supervisor = Supervisor()
//            supervisor.firstName="Stefan"
//                    supervisor.lastName="Vanhille"
//                    supervisor.role=Role.Gardener
//
//                    val supervisor2 = Supervisor()
//                    supervisor2.firstName="Gilles"
//                    supervisor.lastName="Moenaert"
//                    supervisor2.role=Role.Trainer
//                    repository2.save(supervisor)
//                    repository2.save(supervisor2)
//
////            val person=Person()
////            person.email="Stefan.vanhille@hotmail.com"
////            person.name="Stefan"
////            person.lastName="Vanhille"
////            person.phoneNumber="+32476016103"
////
////            val user = User()
////            user.person=person
//
//                    repository2.save(supervisor)
//                    repository2.save(supervisor2)
////            repository3.save(user)
