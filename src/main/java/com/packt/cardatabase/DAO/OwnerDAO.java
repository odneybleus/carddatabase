package com.packt.cardatabase.DAO;

import com.packt.cardatabase.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDAO extends JpaRepository<Owner, Long> {
}
