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
@Table(name = "departments")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "department_id")
    private String id;
    @Column(name = "department_name")
    private String name;
    private String location;

    //moi quan he nhieu mot voi facility
    @OneToMany(mappedBy = "department")
    private Set<Facility> facilities;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Person manager;


    public Department() {
    }

    public Department(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
