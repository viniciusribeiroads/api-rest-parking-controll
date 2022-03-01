package com.parking.vehicle.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_parking_lot")
public class ParkingLot implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "parkinglot")
    private List<Vehicle> vehicles;

    public ParkingLot() {

    }

    public ParkingLot(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(vehicles, that.vehicles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vehicles);
    }
}
