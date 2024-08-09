package org.distributornetwork.repositories;

import org.distributornetwork.entities.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
    List<Distributor> findByDistributorCode(String distributorCode);
}
