package com.eap.manageating.service;

import com.eap.manageating.dao.ListaProdusRepository;
import com.eap.manageating.model.ListaProdus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ListaProdusServiceImpl implements ListaProdusService{
    private ListaProdusRepository listaProdusRepository;

    @Autowired
    public ListaProdusServiceImpl(ListaProdusRepository listaProdusRepository) {
        this.listaProdusRepository = listaProdusRepository;
    }

    @Override
    public List<ListaProdus> findAll() {
        return listaProdusRepository.findAll();
    }

    @Override
    public ListaProdus findById(int theId) {
        Optional<ListaProdus> result = listaProdusRepository.findById(theId);

        ListaProdus listaProdus = null;
        if (result.isPresent()){
            listaProdus = result.get();
        } else {
            throw new RuntimeException("Did not find ListaProdus with id: " + theId);
        }
        return listaProdus;
    }

    @Override
    public List<ListaProdus> findByIdComanda(int id) {
        return listaProdusRepository.findByIdComanda(id);
    }


    @Override
    public void save(ListaProdus listaProdus) {
        listaProdusRepository.save(listaProdus);
    }

    @Override
    public void deleteById(int theId) {
        listaProdusRepository.deleteById(theId);
    }
}
