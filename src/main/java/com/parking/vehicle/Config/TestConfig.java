package com.parking.vehicle.Config;

import com.parking.vehicle.model.Owner;
import com.parking.vehicle.model.ParkingLot;
import com.parking.vehicle.model.Vehicle;
import com.parking.vehicle.repository.OwnerRepository;
import com.parking.vehicle.repository.ParkingLotRepository;
import com.parking.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    @Profile(value = "test")
    public void run(String... args) throws Exception {

        Owner dono1 = new Owner("Marcos","1113332244", new Date() );
        ownerRepository.save(dono1);
        ParkingLot parkingLot = new ParkingLot("Santa Barbara");
        parkingLotRepository.save(parkingLot);
        Vehicle carro1 = new Vehicle(1,"Palio",dono1, parkingLot);
        vehicleRepository.save(carro1);


    }
}
