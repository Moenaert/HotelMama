package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ToDo", schema = "sys", catalog = "")
public class ToDoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ToDoID", nullable = false)
    private Integer toDoId;
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    private String description;

    public Integer getToDoId() {
        return toDoId;
    }

    public ToDoEntity(){

    }
    public void setToDoId(Integer toDoId) {
        this.toDoId = toDoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoEntity that = (ToDoEntity) o;
        return Objects.equals(toDoId, that.toDoId) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toDoId, description);
    }

    @Override
    public String toString() {
        return "ToDoEntity{" +
                "toDoId=" + toDoId +
                ", description='" + description + '\'' +
                '}';
    }
}
