package entity;

import javax.persistence.*;

@Entity
@Table(name = "Users", schema = "sys", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "supervisorID", nullable = true)
    private Integer supervisorId;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @ManyToOne
    @JoinColumn(name = "supervisorID", referencedColumnName = "id")
    private SupervisorEntity supervisorBySupervisorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public SupervisorEntity getSupervisorBySupervisorId() {
        return supervisorBySupervisorId;
    }

    public void setSupervisorBySupervisorId(SupervisorEntity supervisorBySupervisorId) {
        this.supervisorBySupervisorId = supervisorBySupervisorId;
    }
}
