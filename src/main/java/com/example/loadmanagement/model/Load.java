package com.example.loadmanagement.model;

import jakarta.persistence.*; 
import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String shipperId;

    @Embedded
    private Facility facility;

    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private Timestamp datePosted;
    private String status; // POSTED, BOOKED, CANCELLED

}
