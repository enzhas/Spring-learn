package com.example.delivery.models;

import lombok.*;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String city;
    private String phone;
    private String status;

    public void updateStatus() {
        if(this.status.equals("ACTIVE")){
            this.status = "INACTIVE";
        }
        else {
            this.status = "ACTIVE";
        }
    }
}

