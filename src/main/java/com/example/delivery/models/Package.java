package com.example.delivery.models;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "employees_id")
    private Employee employee;



    public Package(String description, String deliveryAddress, Employee employees_id) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.employee = employees_id;
    }
    public Package() {}

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Package [id=" + id + ", desc=" + description + ", deliveryAddress=" + deliveryAddress + ", employees_id=" + employee + "]";
    }
}
