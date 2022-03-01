package com.parking.vehicle.service;

import com.parking.vehicle.model.Vehicle;
import com.parking.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> listAll(){
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    public ResponseEntity<Vehicle> save(Vehicle vehicle) {
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }


    public ResponseEntity deleteBy(Long id) {
        return vehicleRepository.findById(id)
                .map( vehicle -> {
                    vehicleRepository.delete(vehicle);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<Vehicle> update(Vehicle vehicle) {
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }
}
