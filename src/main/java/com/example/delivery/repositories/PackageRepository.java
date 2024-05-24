package com.example.delivery.repositories;

import com.example.delivery.models.Package;
import org.springframework.data.repository.CrudRepository;

public interface PackageRepository extends CrudRepository<Package, Long> {

}