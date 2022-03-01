package com.parking.vehicle.service;

import com.parking.vehicle.model.ParkingLot;
import com.parking.vehicle.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;


    public List<ParkingLot> listAll() {
        return parkingLotRepository.findAll();
    }


    public ResponseEntity<ParkingLot> save(ParkingLot parkingLot) {
        return ResponseEntity.ok(parkingLotRepository.save(parkingLot));
    }


    public ResponseEntity deleteBy(Long id) {
        return parkingLotRepository.findById(id)
                .map( parking -> {
                    parkingLotRepository.delete(parking);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<ParkingLot> update(ParkingLot parkingLot) {
        return ResponseEntity.ok(parkingLotRepository.save(parkingLot));
    }
}
