package com.example.loadmanagement.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.Data;

@Embeddable
@Data
public class Facility {
    private String loadingPoint;
    private String unloadingPoint;
    private Timestamp loadingDate;
    private Timestamp unloadingDate;
}