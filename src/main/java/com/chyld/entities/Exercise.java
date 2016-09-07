package com.chyld.entities;

<<<<<<< HEAD
import com.chyld.enums.ExerciseType;
=======
import com.chyld.enums.ExerciseEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exercises")
@Data
public class Exercise {
<<<<<<< HEAD

    private int id;
    private int version;
    private ExerciseType type;
    private int quantity;
    private int calories;
    private int duration;
    private Date created;
    private Date modified;
    private User user;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('SWIM', 'RUN', 'BIKE', 'LIFT')")
    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
=======
    private int id;
    private int version;
    private ExerciseEnum type;
    private int quantity;
    private int calories;
    private int duration;
    private User user;
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('RUN', 'SWIM', 'BIKE', 'LIFT')")
    public ExerciseEnum getType() {return type;}
    public void setType(ExerciseEnum type) {this.type = type;}

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
>>>>>>> f80f338cf5c11ddb236a45eedfbd68af3162290f
}
