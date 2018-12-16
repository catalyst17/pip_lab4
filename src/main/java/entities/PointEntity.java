package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POINT")
public class PointEntity {
    @Id
    @Column(name = "x")
    private double x;

    @Id
    @Column(name = "y")
    private double y;

    @Id
    @Column(name = "r")
    private double r;

    @Column(name = "in_range")
    private boolean inRange;

    @Id
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name="owner")
    private UserEntity owner;

    public PointEntity() {
    }

    public PointEntity(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isInRange() {
        return inRange;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }
}