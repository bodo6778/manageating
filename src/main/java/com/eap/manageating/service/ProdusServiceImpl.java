package com.eap.manageating.service;

import com.eap.manageating.dao.ProdusRepository;
import com.eap.manageating.model.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdusServiceImpl implements ProdusService{
    private ProdusRepository produsRepository;

    @Autowired
    public ProdusServiceImpl(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }

    @Override
    public List<Produs> findAll() {
        return produsRepository.findAll();
    }

    @Override
    public Produs findById(int theId) {
        Optional<Produs> result = produsRepository.findById(theId);

        Produs produs = null;
        if (result.isPresent()){
            produs = result.get();
        } else {
            throw new RuntimeException("Did not find produs with id - " + theId);
        }
        return produs;
    }

    @Override
    public void save(Produs produs) {
        produsRepository.save(produs);
    }

    @Override
    public void deleteById(int theId) {
        produsRepository.deleteById(theId);
    }
}
