package com.parking.vehicle.controller;

import com.parking.vehicle.model.ParkingLot;
import com.parking.vehicle.model.Vehicle;
import com.parking.vehicle.service.ParkingLotService;
import com.parking.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping(path = "/all")
    public List<ParkingLot> listAll(){
        return parkingLotService.listAll();
    }

    @PostMapping(path = "/new")
    public ResponseEntity<ParkingLot> save (@RequestBody ParkingLot parkingLot){
        return parkingLotService.save(parkingLot);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        return parkingLotService.deleteBy(id);
    }

    @PutMapping("/update")
    public ResponseEntity<ParkingLot> update (@RequestBody ParkingLot parkingLot){
        return parkingLotService.update(parkingLot);
    }
}
