package com.example.delivery.models;

import lombok.*;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String status;
// todo
//  raname change statu add search and rename active and INactive

    public void updateStatus() {
        if(this.status.equals("ACTIVE")){
            this.status = "INACTIVE";
        }
        else {
            this.status = "ACTIVE";
        }
    }
}

