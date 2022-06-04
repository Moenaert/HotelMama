package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Users", schema = "sys", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "supervisorID", nullable = true)
    private Integer supervisorId;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<MtMJoinTableEntity> mtMJoinTablesById;
    @ManyToOne
    @JoinColumn(name = "supervisorID", referencedColumnName = "id")
    private SupervisorEntity supervisorBySupervisorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id && Objects.equals(supervisorId, that.supervisorId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supervisorId, name);
    }

    public Collection<MtMJoinTableEntity> getMtMJoinTablesById() {
        return mtMJoinTablesById;
    }

    public void setMtMJoinTablesById(Collection<MtMJoinTableEntity> mtMJoinTablesById) {
        this.mtMJoinTablesById = mtMJoinTablesById;
    }

    public SupervisorEntity getSupervisorBySupervisorId() {
        return supervisorBySupervisorId;
    }

    public void setSupervisorBySupervisorId(SupervisorEntity supervisorBySupervisorId) {
        this.supervisorBySupervisorId = supervisorBySupervisorId;
    }
}
