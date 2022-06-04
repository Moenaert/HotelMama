package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supervisor", schema = "sys", catalog = "")
public class SupervisorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "test", nullable = true, length = 45)
    private String test;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(test, that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, test);
    }
}
