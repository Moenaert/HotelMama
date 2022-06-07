package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users", schema = "sys", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "UsersID", nullable = false)
    private Integer usersId;
    @Basic
    @Column(name = "username", nullable = true, length = 45)
    private String username;

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(usersId, that.usersId) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersId, username);
    }
}
