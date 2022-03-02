package com.parking.vehicle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_owner")
public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String cpf;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    public Owner() {

    }

    public Owner(String name, String cpf, Date birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name) && Objects.equals(cpf, owner.cpf) && Objects.equals(vehicles, owner.vehicles) && Objects.equals(birthDate, owner.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, vehicles, birthDate);
    }

}
