package com.example.delivery.controllers;

import com.example.delivery.models.Package;
import com.example.delivery.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/packages")
public class PackageController {
    @Autowired
    private PackageService packageService;

    @GetMapping("/{id}")
    public Optional<Package> getPackageById(@PathVariable Long id) {
        return packageService.getPackageById(id);
    }

    @GetMapping
    public Iterable<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @PostMapping
    public Package createPackage(@RequestBody Package pkg) {
        return packageService.savePackage(pkg);
    }

    @DeleteMapping("/{id}")
    public void deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
    }
}
