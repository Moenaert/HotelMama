package com.gilles.hotelmama;

import javax.persistence.*;

@Entity
class UserToDosDos {

    @EmbeddedId
    UserToDosKey UserToDosKey=new UserToDosKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("toDoId")
    @JoinColumn(name = "to_do_id")
    private ToDoEntity todo;

    int combinationTable;

    public com.gilles.hotelmama.UserToDosKey getUserToDosKey() {
        return UserToDosKey;
    }

    public void setUserToDosKey(com.gilles.hotelmama.UserToDosKey userToDosKey) {
        UserToDosKey = userToDosKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ToDoEntity getTodo() {
        return todo;
    }

    public void setTodo(ToDoEntity todo) {
        this.todo = todo;
    }

    public int getCombinationTable() {
        return combinationTable;
    }

    public void setCombinationTable(int combinationTable) {
        this.combinationTable = combinationTable;
    }

    // standard constructors, getters, and setters
}
