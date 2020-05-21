package com.eap.manageating.service;

import com.eap.manageating.model.Produs;

import java.util.List;

public interface ProdusService {
    public List<Produs> findAll();

    public Produs findById(int theId);

    public void save(Produs produs);

    public void deleteById(int theId);
}
