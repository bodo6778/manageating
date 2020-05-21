package com.eap.manageating.service;

import com.eap.manageating.model.Masa;

import java.util.List;

public interface MasaService {
    public List<Masa> findAll();

    public Masa findById(int theId);

    public void save(Masa masa);

    public void deleteById(int theId);
}
