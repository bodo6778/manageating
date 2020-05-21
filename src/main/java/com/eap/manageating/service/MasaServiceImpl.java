package com.eap.manageating.service;

import com.eap.manageating.dao.MasaRepository;
import com.eap.manageating.model.Masa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasaServiceImpl implements MasaService{
    private MasaRepository masaRepository;

    @Autowired
    public MasaServiceImpl(MasaRepository masaRepository) {
        this.masaRepository = masaRepository;
    }

    @Override
    public List<Masa> findAll() {
        return masaRepository.findAll();
    }

    @Override
    public Masa findById(int theId) {
        Optional<Masa> result = masaRepository.findById(theId);

        Masa masa = null;
        if (result.isPresent()){
            masa = result.get();
        } else {
            throw new RuntimeException("Did not find masa with id: " + theId);
        }
        return masa;
    }

    @Override
    public void save(Masa masa) {
        masaRepository.save(masa);
    }

    @Override
    public void deleteById(int theId) {
        masaRepository.deleteById(theId);
    }
}
