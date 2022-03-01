package com.parking.vehicle.service;

import com.parking.vehicle.model.Owner;
import com.parking.vehicle.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> listAll() {

        return ownerRepository.findAll();
    }

    public Owner save(Owner owner) {

        return ownerRepository.save(owner);
    }

    public Owner update(Owner ownerAtualizado, Long id) {
        Owner owner = ownerRepository.getById(id);

        if(owner == null) {
            throw new NoSuchElementException("Não encontrado");
        }

        return ownerRepository.save(ownerAtualizado);
    }

    public void delete(Long id) {
        Owner owner = ownerRepository.getById(id);

        if(owner == null) {
            throw new NoSuchElementException("Não encontrado");
        }

        ownerRepository.deleteById(id);
    }
}
