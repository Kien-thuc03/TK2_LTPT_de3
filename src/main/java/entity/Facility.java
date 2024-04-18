package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "facilities")
@NamedQueries({
        @NamedQuery(name = "Facility.findByID", query = "SELECT f FROM Facility f WHERE f.id = :id"),
        @NamedQuery(name = "Facility.updateFacility",
                query = "UPDATE Facility f SET f.description = :description, f.price = :price, f.status = :status, f.location = :location WHERE f.id = :id"),
        @NamedQuery(name = "Facility.countMaintenance",
                query = "SELECT f, COUNT(m) FROM Facility f JOIN f.maintenances m GROUP BY f ORDER BY f.name ASC")

})
public class Facility implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "facility_id")
    private String id;
    @Column(name = "facility_name")
    private String name;
    private String description;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String location;


    //moi quan he nhieu mot voi department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    //moi quan he nhieu mot voi maintenance
    @OneToMany(mappedBy = "facility")
    private Set<Maintenance> maintenances;




    public Facility() {
    }

    public Facility(String id, String name, String description, LocalDate purchaseDate, double price, Status status, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", status=" + status +
                ", location='" + location + '\'' +
                '}';
    }
}
