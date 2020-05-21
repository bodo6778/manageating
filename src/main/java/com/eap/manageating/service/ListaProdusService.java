package com.eap.manageating.service;

import com.eap.manageating.model.ListaProdus;

import java.util.List;

public interface ListaProdusService {
    public List<ListaProdus> findAll();

    public ListaProdus findById(int theId);

    public List<ListaProdus> findByIdComanda(int id);

    public void save(ListaProdus listaProdus);

    public void deleteById(int theId);
}
