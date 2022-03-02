package com.parking.vehicle.controller;

import com.parking.vehicle.model.Owner;
import com.parking.vehicle.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/all")
    public List<Owner> listAll() {
        return ownerService.listAll();

    }

    @PostMapping("/new")
    public ResponseEntity<Owner> save(@RequestBody Owner owner) {
        return ResponseEntity.ok().body(ownerService.save(owner));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Owner> update(@RequestBody Owner owner, @PathVariable Long id) {
        return ResponseEntity.ok().body(ownerService.update(owner, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        ownerService.delete(id);

        return ResponseEntity.ok().build();
    }
}
