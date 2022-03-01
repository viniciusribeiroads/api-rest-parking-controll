package com.parking.vehicle.model;

public enum Manufacturer {
    
    Volkswagem(1),
    Fiat(2),
    Ford(3),
    Peugeot(4),
    Honda(5),
    Yamaha(6);

    int manufacturerNumber;

    Manufacturer(int value){
        this.manufacturerNumber = value;
    }

    public static Manufacturer valueOf(int number){
        for (Manufacturer manufacturer : Manufacturer.values()){
            if (manufacturer.manufacturerNumber == number){
                return manufacturer;
            }
        }
        throw new IllegalArgumentException("Invalid manufacturer number!");
    }
}
