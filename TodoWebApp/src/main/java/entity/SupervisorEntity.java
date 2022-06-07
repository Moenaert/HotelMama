package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supervisor", schema = "sys", catalog = "")
public class SupervisorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SupervisorID", nullable = false)
    private Integer supervisorId;
    @Basic
    @Column(name = "supervisorname", nullable = true, length = 45)
    private String supervisorname;
    @Basic
    @Column(name = "test", nullable = true, length = 45)
    private String test;

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getSupervisorname() {
        return supervisorname;
    }

    public void setSupervisorname(String supervisorname) {
        this.supervisorname = supervisorname;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupervisorEntity that = (SupervisorEntity) o;
        return Objects.equals(supervisorId, that.supervisorId) && Objects.equals(supervisorname, that.supervisorname) && Objects.equals(test, that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supervisorId, supervisorname, test);
    }
}
