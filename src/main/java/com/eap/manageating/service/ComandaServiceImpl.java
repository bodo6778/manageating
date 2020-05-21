package com.eap.manageating.service;

import com.eap.manageating.dao.ComandaRepository;
import com.eap.manageating.model.Comanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComandaServiceImpl implements ComandaService{
    private ComandaRepository comandaRepository;

    @Autowired
    public ComandaServiceImpl(ComandaRepository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }


    @Override
    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    @Override
    public Comanda findById(int theId) {
        Optional<Comanda> result = comandaRepository.findById(theId);

        Comanda comanda = null;
        if (result.isPresent()){
            comanda = result.get();
        } else {
            throw new RuntimeException("Did not find comanda with id: " + theId);
        }
        return comanda;
    }

    @Override
    public void save(Comanda comanda) {
        comandaRepository.save(comanda);
    }

    @Override
    public void deleteById(int theId) {
        comandaRepository.deleteById(theId);
    }
}
