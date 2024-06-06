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

    @GetMapping("/all")
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/single/{id}")
    public Optional<Package> getPackageById(@PathVariable UUID id) {
        return packageService.getPackageById(id);
    }

    @PostMapping("/create")
    public int createPackage(@RequestBody Package pack) {
        return packageService.savePackage(pack);
    }

    @PutMapping("/update")
    public int updatePackage(@RequestBody Package pack) {
        return packageService.updatePackage(pack);
    }

    @DeleteMapping("/delete")
    public int deletePackage(@RequestParam UUID id) {
        return packageService.deletePackage(id);
    }
}
