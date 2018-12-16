package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @Column(name="login", nullable = false, length = 30)
    private String login;

    @Column(name="password", nullable = false, length = 40)
    private int password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointEntity> points;

    public UserEntity() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public void setPoints(List<PointEntity> points) {
        this.points = points;
    }

    public List<PointEntity> getPoints() {
        return points;
    }

    public void addComment(PointEntity point) {
        points.add(point);
        point.setOwner(this);
    }

    public void removeComment(PointEntity point) {
        points.remove(point);
        point.setOwner(null);
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }*/
}
