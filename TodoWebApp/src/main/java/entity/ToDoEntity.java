package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ToDo", schema = "sys", catalog = "")
public class ToDoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    private String description;
    @OneToMany(mappedBy = "toDoByToDoId")
    private Collection<MtMJoinTableEntity> mtMJoinTablesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id == that.id && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public Collection<MtMJoinTableEntity> getMtMJoinTablesById() {
        return mtMJoinTablesById;
    }

    public void setMtMJoinTablesById(Collection<MtMJoinTableEntity> mtMJoinTablesById) {
        this.mtMJoinTablesById = mtMJoinTablesById;
    }
}
