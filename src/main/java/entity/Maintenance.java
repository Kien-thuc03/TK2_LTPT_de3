package entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * @description
 * @author: nktng,
 * @date:18/04/2024,
 */
@Entity
@Table(name = "maintenances")
@NamedQueries(
        {
                @NamedQuery(name = "Maintenance.findAll", query = "SELECT m FROM Maintenance m"),
                @NamedQuery(name = "Maintenance.findByFacility", query = "SELECT m FROM Maintenance m WHERE m.facility.id = :facilityId"),
                @NamedQuery(name = "Maintenance.findByFacilityName",
    query = "SELECT DISTINCT p FROM Person p JOIN p.maintenances m JOIN m.facility f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :facilityName, '%')) AND m.cost > 0")     }
)
public class Maintenance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    private String description;
    private double cost;


    //moi quan he nhieu mot voi facility
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    //moi quan he nhieu mot voi people
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public Maintenance() {
    }

    public Maintenance(String startDate, String endDate, String description, double cost) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.cost = cost;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
