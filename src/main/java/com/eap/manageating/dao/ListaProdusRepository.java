package com.eap.manageating.dao;

import com.eap.manageating.model.ListaProdus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ListaProdusRepository extends JpaRepository<ListaProdus, Integer> {
    public List<ListaProdus> findByIdComanda(int id);
}
