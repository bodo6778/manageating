package com.eap.manageating.controller;

import com.eap.manageating.model.Comanda;
import com.eap.manageating.model.ListaProdus;
import com.eap.manageating.model.Produs;
import com.eap.manageating.service.ComandaService;
import com.eap.manageating.service.ListaProdusService;
import com.eap.manageating.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lista")
public class ListaProdusController {

    private ComandaService comandaService;
    private ListaProdusService listaProdusService;
    private ProdusService produsService;

    @Autowired
    public ListaProdusController(ComandaService comandaService, ListaProdusService listaProdusService, ProdusService produsService) {
        this.comandaService = comandaService;
        this.listaProdusService = listaProdusService;
        this.produsService = produsService;
    }

    @GetMapping("/list")
    public String afisareListaProduse(@RequestParam("idComanda") int comanda,
                                      Model model){
        Comanda comanda1 = comandaService.findById(comanda);
        List<ListaProdus> listaProduse = comanda1.getListaProduse();
        //List<ListaProdus> listaProduse = listaProdusService.findByIdComanda(comanda);
        model.addAttribute("listaProduse",listaProduse);
        return "comenzi/listaProduse";
    }

    @PostMapping("/save")
    @Transactional
    public String saveListaProdus(@ModelAttribute("listaProdus") ListaProdus listaProdus) {
        Produs produs = produsService.findById(listaProdus.getIdProdus().getIdProdus());

        //adauga la totalul comenzii pretul prodului adaugat * cate produse s-au comandat
        int pretDeAdaugat = listaProdus.getCantitate() * produs.getPret();
        listaProdus.getIdComanda().addTotal(pretDeAdaugat);

        //mareste popularitatea
        produs.crestePopularitate(listaProdus.getCantitate());

        //salveaza produsul
        listaProdusService.save(listaProdus);

        return "redirect:/comenzi/list";
    }


}
