package com.eap.manageating.service;

import com.eap.manageating.model.Comanda;
import com.eap.manageating.model.Masa;

import java.util.List;

public interface ComandaService {
    public List<Comanda> findAll();

    public Comanda findById(int theId);

    public void save(Comanda comanda);

    public void deleteById(int theId);
}
