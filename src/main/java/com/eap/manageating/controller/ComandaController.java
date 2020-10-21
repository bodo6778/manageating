package com.eap.manageating.controller;

import com.eap.manageating.model.*;
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
@RequestMapping("/comenzi")
public class ComandaController {
    private ComandaService comandaService;
    private ListaProdusService listaProdusService;
    private ProdusService produsService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @Autowired
    public ComandaController(ComandaService comandaService, ListaProdusService listaProdusService, ProdusService produsService) {
        this.comandaService = comandaService;
        this.listaProdusService = listaProdusService;
        this.produsService = produsService;
    }

    @GetMapping("/list")
    public String listComenzi(Model model){
        //afisare comenzi
        List<Comanda> comenzi = comandaService.findAll();
        model.addAttribute("comenzi", comenzi);
        return "comenzi/listacomenzi";
    }

    @PostMapping("/save")
    public String saveComanda(@ModelAttribute("comanda") Comanda comanda) {

        comandaService.save(comanda);

        // use a redirect to prevent duplicate submissions
        return "redirect:/comenzi/list";
    }


    @GetMapping("/finalizare")
    @Transactional
    public String finalizareComanda(@RequestParam("comanda") int idComanda){
        Comanda comanda = comandaService.findById(idComanda);
        comanda.setFinalizata(true);
        comanda.getStaff().addNrComLivrateOne();
        return "redirect:/comenzi/list";
    }

    @GetMapping("/adaugaProdus")
    @Transactional
    public String adaugaProdus(@RequestParam("idComanda") int idComanda,
                               Model model){

        ListaProdus listaProdus = new ListaProdus();
        List<Produs> produse = produsService.findAll();
        List<Comanda> comenzi = comandaService.findAll();


        model.addAttribute("comenzi", comenzi);
        model.addAttribute("produse",produse);
        model.addAttribute("comanda",comandaService.findById(idComanda));
        model.addAttribute("listaProdus",listaProdus);
        return "comenzi/adaugaProdus";
    }


}
