package com.example.delivery.models;

import java.util.UUID;

public class Package {
    private UUID id;
    private String description;
    private String deliveryAddress;
    private Employee employee;

    public Package(String description, String deliveryAddress, Employee employee) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.employee = employee;
    }

    public Package() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Package [id=" + id + ", description=" + description + ", deliveryAddress=" + deliveryAddress + ", employee=" + employee + "]";
    }
}
