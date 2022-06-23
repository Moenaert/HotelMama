package com.gilles.hotelmama;

import javax.persistence.*;

@Entity
class UserToDosDos {

    @EmbeddedId
    UserToDosKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "to_do_id")
    ToDoEntity todo;

    int combinationTable;

    // standard constructors, getters, and setters
}
