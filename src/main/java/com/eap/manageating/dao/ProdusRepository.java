package com.eap.manageating.dao;

import com.eap.manageating.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository extends JpaRepository<Produs, Integer> {
}
