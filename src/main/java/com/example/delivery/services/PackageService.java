package com.example.delivery.services;

import com.example.delivery.models.Package;
import com.example.delivery.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;

    public Optional<Package> getPackageById(Long id) {
        return packageRepository.findById(id);
    }

    public Iterable<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    public Package savePackage(Package pkg) {
        return packageRepository.save(pkg);
    }

    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}
