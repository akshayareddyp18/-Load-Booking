package com.example.loadmanagement.service;

import com.example.loadmanagement.model.Load;
import java.util.List;
import java.util.UUID;

public interface LoadService {
    Load createLoad(Load load);
    List<Load> getAllLoads(String shipperId, String truckType);
    Load getLoadById(UUID loadId);
    Load updateLoad(UUID loadId, Load load);
    void deleteLoad(UUID loadId);
    void updateLoadStatus(UUID loadId, String status);
}