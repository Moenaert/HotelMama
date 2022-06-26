package com.gilles.hotelmama;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class UserToDosKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "to_do_id")
    Long toDoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserToDosKey that = (UserToDosKey) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return toDoId != null ? toDoId.equals(that.toDoId) : that.toDoId == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (toDoId != null ? toDoId.hashCode() : 0);
        return result;
    }
}
