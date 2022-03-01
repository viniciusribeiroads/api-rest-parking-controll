package com.parking.vehicle.controller;

import com.parking.vehicle.model.Vehicle;
import com.parking.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "/all")
    public List<Vehicle> listAll(){
        return vehicleService.listAll();
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Vehicle> save (@RequestBody Vehicle vehicle){
        return vehicleService.save(vehicle);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        return vehicleService.deleteBy(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Vehicle> update (@RequestBody Vehicle vehicle){
        return vehicleService.update(vehicle);
    }





}
