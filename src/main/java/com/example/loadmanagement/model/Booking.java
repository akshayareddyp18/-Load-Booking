package com.example.loadmanagement.model;

import jakarta.persistence.*; 
import java.sql.Timestamp;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID loadId;
    private String transporterId;
    private double proposedRate;
    private String comment;
    private String status; // PENDING, ACCEPTED, REJECTED
    private Timestamp requestedAt;

}