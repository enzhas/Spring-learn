package com.example.delivery.services;

import com.example.delivery.models.Package;
import com.example.delivery.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    public Optional<Package> getPackageById(UUID id) {
        return packageRepository.findById(id);
    }

    public int savePackage(Package pack) {
        return packageRepository.save(pack);
    }

    public int deletePackage(UUID id) {
        return packageRepository.deleteById(id);
    }
}
