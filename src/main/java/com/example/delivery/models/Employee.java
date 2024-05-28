package com.example.delivery.models;

public class Employee {
    private Long id;
    private String name;
    private String status;

    public Employee(String name) {
        this.name = name;
        this.status = "ACTIVE";
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
        this.status = "ACTIVE";
    }

    public Employee() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
    public void changeStatus() {
        if(this.status.equals("ACTIVE")){
            this.status = "INACTIVE";
        }
        else {
            this.status = "ACTIVE";
        }
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
