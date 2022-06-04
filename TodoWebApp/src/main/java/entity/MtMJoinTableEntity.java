package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MtM Join Table", schema = "sys", catalog = "")
public class MtMJoinTableEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "JoinID", nullable = false)
    private int joinId;
    @Basic
    @Column(name = "UserID", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "ToDoID", nullable = true)
    private Integer toDoId;

    public int getJoinId() {
        return joinId;
    }

    public void setJoinId(int joinId) {
        this.joinId = joinId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToDoId() {
        return toDoId;
    }

    public void setToDoId(Integer toDoId) {
        this.toDoId = toDoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MtMJoinTableEntity that = (MtMJoinTableEntity) o;
        return joinId == that.joinId && Objects.equals(userId, that.userId) && Objects.equals(toDoId, that.toDoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinId, userId, toDoId);
    }
}
