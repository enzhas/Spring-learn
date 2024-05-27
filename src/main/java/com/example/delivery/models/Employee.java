package com.example.delivery.models;

public class Employee {
    private Long id;
    private String name;

    public Employee(int id, String name) {
        this.id = (long) id; // convert int to long
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
