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
    public ResponseEntity<List<Owner>> listAll() {
        ownerService.listAll();

        return ResponseEntity.ok().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Owner> save(@RequestBody Owner owner) {
        ownerService.save(owner);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Owner> update(@RequestBody Owner owner, @PathVariable Long id) {
        ownerService.update(owner, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        ownerService.delete(id);

        return ResponseEntity.ok().build();
    }
}
