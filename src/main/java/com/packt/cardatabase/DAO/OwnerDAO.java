package com.packt.cardatabase.DAO;

import com.packt.cardatabase.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerDAO extends JpaRepository<Owner, Long> {
    Optional<Owner> getOwnerByUserName(String userName);
}
