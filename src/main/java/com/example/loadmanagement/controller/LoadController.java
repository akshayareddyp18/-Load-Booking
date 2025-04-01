package com.example.loadmanagement.controller;

import com.example.loadmanagement.model.Load; // Updated import
import com.example.loadmanagement.service.LoadService; // Updated import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {
    @Autowired
    private LoadService loadService;
    @PostMapping
    public ResponseEntity<Load> createLoad(@RequestBody Load load) {
        return new ResponseEntity<>(loadService.createLoad(load), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Load>> getAllLoads(@RequestParam(value="shipperId", required = false) String shipperId, @RequestParam(value="truckType", required = false) String truckType) {
        return new ResponseEntity<>(loadService.getAllLoads(shipperId, truckType), HttpStatus.OK);
    }
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        return new ResponseEntity<>(loadService.getLoadById(loadId), HttpStatus.OK);
    }
    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable UUID loadId, @RequestBody Load load) {
        return new ResponseEntity<>(loadService.updateLoad(loadId, load), HttpStatus.OK);
    }
    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}