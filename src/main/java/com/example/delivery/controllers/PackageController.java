package com.example.delivery.controllers;

import com.example.delivery.models.Package;
import com.example.delivery.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/packages")
public class PackageController {
    @Autowired
    private PackageService packageService;

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/{id}")
    public Optional<Package> getPackageById(@PathVariable UUID id) {
        return packageService.getPackageById(id);
    }

    @PostMapping
    public int createPackage(@RequestBody Package pack) {
        System.out.println();
        System.out.println(pack);
        System.out.println();
        return packageService.savePackage(pack);
    }

    @PutMapping("/{id}")
    public int updatePackage(@RequestBody Package pack) {
        return packageService.updatePackage(pack);
    }

    @DeleteMapping("/{id}")
    public int deletePackage(@PathVariable UUID id) {
        return packageService.deletePackage(id);
    }
}
