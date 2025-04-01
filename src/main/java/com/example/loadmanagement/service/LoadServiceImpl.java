package com.example.loadmanagement.service;

import com.example.loadmanagement.exception.ResourceNotFoundException;
import com.example.loadmanagement.model.Load;
import com.example.loadmanagement.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadRepository loadRepository;

    @Override
    public Load createLoad(Load load) {
        load.setDatePosted(new Timestamp(System.currentTimeMillis()));
        load.setStatus("POSTED");
        return loadRepository.save(load);
    }

    @Override
    public List<Load> getAllLoads(String shipperId, String truckType) {
        if(shipperId != null){
            return loadRepository.findByShipperId(shipperId);
        }
        if(truckType != null){
            return loadRepository.findByTruckType(truckType);
        }
        return loadRepository.findAll();
    }

    @Override
    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId)
                .orElseThrow(() -> new ResourceNotFoundException("Load not found with id: " + loadId));
    }

    @Override
    public Load updateLoad(UUID loadId, Load load) {
        Load existingLoad = getLoadById(loadId);
        existingLoad.setShipperId(load.getShipperId());
        existingLoad.setFacility(load.getFacility());
        existingLoad.setProductType(load.getProductType());
        existingLoad.setTruckType(load.getTruckType());
        existingLoad.setNoOfTrucks(load.getNoOfTrucks());
        existingLoad.setWeight(load.getWeight());
        existingLoad.setComment(load.getComment());

        return loadRepository.save(existingLoad);
    }

    @Override
    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }

    @Override
    public void updateLoadStatus(UUID loadId, String status) {
        Load existingLoad = getLoadById(loadId);
        existingLoad.setStatus(status);
        loadRepository.save(existingLoad);
    }
}