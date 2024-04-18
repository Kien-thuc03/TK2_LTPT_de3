package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 * @description
 * @author: nktng,
 * @date:18/04/2024,
 */
@Entity
@Table(name = "people")

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "person_id")
    private String id;
    @Column(name = "full_name")
    private String name;
    private String position;
    private String phone;
    private String email;


    //moi quan he nhieu mot voi maintenance
    @OneToMany(mappedBy = "person")
    private Set<Maintenance> maintenances;

    //moi quan he mot mot voi department
    @OneToOne(mappedBy = "manager")
    private Department department;



    public Person() {
    }

    public Person(String id, String name, String position, String phone, String email) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
