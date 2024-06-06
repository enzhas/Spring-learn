package com.example.delivery.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    private UUID id;
    private String description;
    private String deliveryAddress;
    private String city;
    private String street;
    private String deliveryPhoneNumber;
    private Employee employee;
}
